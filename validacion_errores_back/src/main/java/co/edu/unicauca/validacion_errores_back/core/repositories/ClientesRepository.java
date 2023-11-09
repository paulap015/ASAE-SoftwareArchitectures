package co.edu.unicauca.validacion_errores_back.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.validacion_errores_back.core.models.Cliente;

@Repository
public interface ClientesRepository extends CrudRepository<Cliente,Integer>{
    
}
