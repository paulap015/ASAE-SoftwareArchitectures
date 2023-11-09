package co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Estudiante;

public interface EstudiantesRepository extends CrudRepository<Estudiante, Integer> {

}