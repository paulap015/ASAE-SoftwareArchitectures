package co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Usuario;



public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {

}
