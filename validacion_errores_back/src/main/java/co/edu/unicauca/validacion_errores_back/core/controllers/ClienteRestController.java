package co.edu.unicauca.validacion_errores_back.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.validacion_errores_back.core.models.Cliente;
import co.edu.unicauca.validacion_errores_back.core.services.IClienteServices;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteServices clienteService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/cabecera/{id}")
    ResponseEntity<String> cabeceraPersonalizada(@PathVariable Integer id) {

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Estado Cliente", "Cliente con id " + id + ": habilitado");

        return new ResponseEntity<>("Bienvenido " + id, cabecera, HttpStatus.OK);
    }

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Cliente objCliente = null;
        HashMap<String, Object> respuestas = new HashMap();
        ResponseEntity<?> objRespuesta;
        try {
            objCliente = clienteService.findById(id);

            if (objCliente == null) {
                respuestas.put("mensaje", "El cliente con ID: " + id + " no existe en la base de datos");
                objRespuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.NOT_FOUND);
            } else {
                objRespuesta = new ResponseEntity<Cliente>(objCliente, HttpStatus.OK);
            }

        } catch (DataAccessException e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            objRespuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return objRespuesta;
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {
        Cliente objCliente = null;
        HashMap<String, Object> respuestas = new HashMap();
        ResponseEntity<?> objRespuesta;
        try {
            objCliente = clienteService.save(cliente);
            objRespuesta = new ResponseEntity<Cliente>(objCliente, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            respuestas.put("mensaje", "Error al realizar la inserción en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            objRespuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.BAD_REQUEST);

        }

        return objRespuesta;
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Cliente objCliente = null;
        HashMap<String, Object> respuestas = new HashMap();
        ResponseEntity<?> objRespuesta;
        try {
            objCliente = clienteService.findById(id);

            if (objCliente == null) {
                respuestas.put("mensaje",
                        "El cliente con ID: " + id + "que se desea eliminar no existe en la base de datos");
                objRespuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.NOT_FOUND);
            } else {
                clienteService.delete(id);
                objRespuesta = new ResponseEntity<Cliente>(objCliente, HttpStatus.OK);
            }

        } catch (DataAccessException e) {
            respuestas.put("mensaje", "Error al realizar la eliminación del cliente en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            objRespuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return objRespuesta;
    }

}
