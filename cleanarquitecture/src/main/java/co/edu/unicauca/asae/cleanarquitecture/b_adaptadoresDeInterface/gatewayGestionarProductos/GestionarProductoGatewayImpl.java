package co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.a_frameworks.repositorios.ProductoRepositoryInt;
import co.edu.unicauca.asae.cleanarquitecture.a_frameworks.repositorios.entidades.ProductoEntity;
import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.Producto;

@Service
public class GestionarProductoGatewayImpl implements GestionarProductoGatewayInt {

    private final ProductoRepositoryInt objProductoRepository;
    private final ModelMapper productoModelMapper;

    public GestionarProductoGatewayImpl(ProductoRepositoryInt objProductoRepository, ModelMapper productoModelMapper) {
        this.objProductoRepository = objProductoRepository;
        this.productoModelMapper = productoModelMapper;
    }

    @Override
    public boolean existeProductoPorCodigo(String codigo) {
        return this.objProductoRepository.existeProductoPorCodigo(codigo);
    }

    @Override
    public Producto guardar(Producto objProducto) {
        ProductoEntity objProductoEntity = this.productoModelMapper.map(objProducto, ProductoEntity.class);
        ProductoEntity objProductoEntityRegistrado = this.objProductoRepository.save(objProductoEntity);
        Producto objProductoRespuesta = this.productoModelMapper.map(objProductoEntityRegistrado, Producto.class);
        return objProductoRespuesta;
    }

    @Override
    public List<Producto> listar() {
        List<ProductoEntity> lista = this.objProductoRepository.findAll();
        List<Producto> listaObtenida = this.productoModelMapper.map(lista, new TypeToken<List<Producto>>() {
        }.getType());
        return listaObtenida;
    }

}