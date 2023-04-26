package controller;


import model.Notas;
import org.bson.types.ObjectId;
import services.NotasService;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.json.*;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/notas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotasController {

    @Inject
    NotasService notasService;

    @GET
    public Response findAll() {
        List<Notas> notasList = notasService.findAll();

        if (!notasList.isEmpty()) {
            return Response.status(Response.Status.OK).entity(notasList).build();
        } else {
            JsonObject json = Json.createObjectBuilder()
                    .add("error", "No se encontraron registros")
                    .build();
            return Response.status(Response.Status.NOT_FOUND).entity(json).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") ObjectId id) {
        Notas notas = notasService.findById(id);
        if (notas == null) {
            JsonObject error = Json.createObjectBuilder()
                    .add("error", "Nota no encontrada")
                    .build();
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        } else {
            return Response.ok(notas).build();
        }
    }

    @POST
    public Response createNotas(@Valid Notas notas) {
        notas.fechaCreacion = LocalDate.now();
        notas.persist();
        notasService.create(notas);
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT
    public Response update(Notas notas) {
        ObjectId objectId = new ObjectId(String.valueOf(notas.id));
        Notas notasUpdated = notasService.findById(objectId);

        if (notasUpdated != null) {
            notasUpdated.titulo = notas.titulo;
            notasUpdated.contenido = notas.contenido;
            notasUpdated.update();
            JsonObject json = Json.createObjectBuilder()
                    .add("Update", "Registro modificado con éxito")
                    .build();
            return Response.status(Response.Status.OK).entity(json).build();
        } else {
            JsonObject json = Json.createObjectBuilder()
                    .add("error", "El registro no existe")
                    .build();
            return Response.status(Response.Status.NOT_FOUND).entity(json).build();
        }
    }

    @DELETE
    public Response delete(Notas notas) {
        ObjectId objectId = new ObjectId(String.valueOf(notas.id));
        Notas notasDelete = notasService.findById(objectId);

        if (notasDelete != null) {
            notasDelete.delete();
            JsonObject json = Json.createObjectBuilder()
                    .add("Delete", "Registro eliminado con éxito")
                    .build();
            return Response.status(Response.Status.OK).entity(json).build();
        } else {
            JsonObject json = Json.createObjectBuilder()
                    .add("error", "El registro no existe")
                    .build();
            return Response.status(Response.Status.NOT_FOUND).entity(json).build();
        }
    }
}

