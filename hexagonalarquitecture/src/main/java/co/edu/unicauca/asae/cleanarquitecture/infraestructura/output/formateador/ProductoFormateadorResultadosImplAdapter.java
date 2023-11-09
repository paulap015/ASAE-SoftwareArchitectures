package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.formateador;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.ProductoFormateadorResultadosIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Producto;

@Service
public class ProductoFormateadorResultadosImplAdapter implements ProductoFormateadorResultadosIntPort {

    @Override
    public Producto prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

}