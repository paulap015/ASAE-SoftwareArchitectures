package co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Libro;

public interface LibrosRepository extends CrudRepository<Libro, Integer> {

}
