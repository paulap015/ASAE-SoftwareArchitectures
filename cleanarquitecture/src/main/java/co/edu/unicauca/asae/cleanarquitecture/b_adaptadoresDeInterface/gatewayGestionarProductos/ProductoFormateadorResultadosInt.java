package co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTORespuesta.ProductoDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.Producto;

public interface ProductoFormateadorResultadosInt {
    public ProductoDTORespuesta prepararRespuestaSatisfactoriaCrearProducto(Producto objProductoCreado);

    public List<ProductoDTORespuesta> prepararRespuestaSatisfactoriaListarProductos(List<Producto> objProductos);

    public ProductoDTORespuesta prepararRespuestaFallida(String error);
}