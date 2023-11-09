package co.edu.unicauca.validacion_errores_back.core.services;

import java.util.List;

import co.edu.unicauca.validacion_errores_back.core.models.Cliente;



public interface IClienteServices {
    public List<Cliente> findAll();		
	public Cliente findById(Integer id);	
	public Cliente save(Cliente cliente);		
	public void delete(Integer id);
}
