
package co.edu.unicauca.asae.cleanarquitecture.c_reglasDeNegocioAplicacion.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTOPeticion.ProductoDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTORespuesta.ProductoDTORespuesta;

public interface GestionarProductoCUInt {
    public ProductoDTORespuesta crear(ProductoDTOPeticion objProductoPeticion);

    public List<ProductoDTORespuesta> listar();
}