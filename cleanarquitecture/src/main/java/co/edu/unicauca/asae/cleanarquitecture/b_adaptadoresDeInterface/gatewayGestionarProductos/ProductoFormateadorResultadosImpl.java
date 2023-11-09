package co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTORespuesta.ProductoDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.Producto;

@Service
public class ProductoFormateadorResultadosImpl implements ProductoFormateadorResultadosInt {

    private final ModelMapper productoModelMapper;

    public ProductoFormateadorResultadosImpl(ModelMapper productoModelMapper) {
        this.productoModelMapper = productoModelMapper;
    }

    @Override
    public ProductoDTORespuesta prepararRespuestaSatisfactoriaCrearProducto(Producto objProductoCreado) {
        ProductoDTORespuesta objProductoDTORespuesta = this.productoModelMapper.map(objProductoCreado,
                ProductoDTORespuesta.class);
        return objProductoDTORespuesta;
    }

    @Override
    public List<ProductoDTORespuesta> prepararRespuestaSatisfactoriaListarProductos(List<Producto> objProductos) {
        List<ProductoDTORespuesta> listaObtenida = this.productoModelMapper.map(objProductos,
                new TypeToken<List<ProductoDTORespuesta>>() {
                }.getType());
        return listaObtenida;
    }

    @Override
    public ProductoDTORespuesta prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

}