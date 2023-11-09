

package co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Producto;



public interface ProductosRepository extends CrudRepository<Producto, Integer> {

}
