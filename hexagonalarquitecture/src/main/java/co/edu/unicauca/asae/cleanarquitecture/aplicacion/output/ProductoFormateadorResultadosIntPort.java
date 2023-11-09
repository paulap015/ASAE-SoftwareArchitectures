package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Producto;

public interface ProductoFormateadorResultadosIntPort {

    public Producto prepararRespuestaFallida(String error);
}