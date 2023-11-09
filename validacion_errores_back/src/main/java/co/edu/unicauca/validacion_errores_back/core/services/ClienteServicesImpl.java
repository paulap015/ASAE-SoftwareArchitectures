package co.edu.unicauca.validacion_errores_back.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.validacion_errores_back.core.models.Cliente;
import co.edu.unicauca.validacion_errores_back.core.repositories.ClientesRepository;

@Service
public class ClienteServicesImpl implements IClienteServices{
    
    @Autowired
    private ClientesRepository servicioAccesoBaseDatos;

    @Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {		
		return (List<Cliente>) this.servicioAccesoBaseDatos.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Integer id) {		
		return this.servicioAccesoBaseDatos.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {		
		return this.servicioAccesoBaseDatos.save(cliente);
	}

	@Override
	public void delete(Integer id) {
		this.servicioAccesoBaseDatos.deleteById(id);		
	}


}
