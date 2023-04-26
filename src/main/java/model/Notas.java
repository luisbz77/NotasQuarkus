package model;

import java.time.LocalDate;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MongoEntity(collection = "notas")
public class Notas extends PanacheMongoEntity{
    @NotNull
    @Size(min = 5)
    public String titulo;
    public String contenido;
    public LocalDate fechaCreacion;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
