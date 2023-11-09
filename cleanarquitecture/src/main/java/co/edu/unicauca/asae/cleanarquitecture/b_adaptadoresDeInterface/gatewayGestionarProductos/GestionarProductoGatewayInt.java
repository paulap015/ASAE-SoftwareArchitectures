package co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.Producto;

public interface GestionarProductoGatewayInt {
    public boolean existeProductoPorCodigo(String codigo);

    public Producto guardar(Producto objProducto);

    public List<Producto> listar();
}