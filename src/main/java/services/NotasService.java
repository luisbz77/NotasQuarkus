package services;


import model.Notas;
import org.bson.types.ObjectId;
import repository.NotasRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class NotasService {

    @Inject
    NotasRepository notasRepository;

    public List<Notas> findAll(){return notasRepository.listAll();}

    public Notas findById(ObjectId id){return notasRepository.findById(id);}

    public void create(Notas notas) {
        notasRepository.persist(notas);
    }

    public void update(Notas notas) {
        notasRepository.update(notas);
    }

    public void delete(ObjectId id) {
        notasRepository.deleteById(id);
    }
}
