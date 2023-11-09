package co.edu.unicauca.asae.cleanarquitecture.c_reglasDeNegocioAplicacion.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTOPeticion.ProductoDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTORespuesta.ProductoDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos.GestionarProductoGatewayInt;
import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos.ProductoFormateadorResultadosInt;
import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.Producto;
import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.ProductoFactoryInt;

public class GestionarProductoCU implements GestionarProductoCUInt {

    private final GestionarProductoGatewayInt objGestionarProductoGateway;
    private final ProductoFormateadorResultadosInt objProductoFormateadorResultados;
    private final ProductoFactoryInt objProductoFactory;

    public GestionarProductoCU(GestionarProductoGatewayInt objRegistrarProductoGateway,
            ProductoFormateadorResultadosInt objProductoFormateadorResultados,
            ProductoFactoryInt objProductoFactory) {
        this.objGestionarProductoGateway = objRegistrarProductoGateway;
        this.objProductoFormateadorResultados = objProductoFormateadorResultados;
        this.objProductoFactory = objProductoFactory;
    }

    @Override
    public ProductoDTORespuesta crear(ProductoDTOPeticion objProductoPeticion) {
        if (this.objGestionarProductoGateway.existeProductoPorCodigo(objProductoPeticion.getCodigo())) {
            return this.objProductoFormateadorResultados
                    .prepararRespuestaFallida("Error, se encuentra en el sistema un producto con el codigo");
        } else {
            Producto objProducto = this.objProductoFactory.crear(objProductoPeticion.getId(),
                    objProductoPeticion.getCodigo(), objProductoPeticion.getNombre(),
                    objProductoPeticion.getTipo(), objProductoPeticion.getTipo());

            if (!objProducto.tipoProductoCorrespondeACodigo()) {
                return this.objProductoFormateadorResultados
                        .prepararRespuestaFallida("Error, el codigo no corresponde con el tipo de producto");
            } else {

                Producto objProductoCreado = this.objGestionarProductoGateway.guardar(objProducto);
                return this.objProductoFormateadorResultados
                        .prepararRespuestaSatisfactoriaCrearProducto(objProductoCreado);
            }
        }

    }

    @Override
    public List<ProductoDTORespuesta> listar() {
        List<Producto> listaObtenida = objGestionarProductoGateway.listar();
        return this.objProductoFormateadorResultados.prepararRespuestaSatisfactoriaListarProductos(listaObtenida);
    }

}