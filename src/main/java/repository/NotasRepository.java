package repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Notas;

import javax.enterprise.inject.Default;

@Default
public interface NotasRepository extends PanacheMongoRepository<Notas> {
}
