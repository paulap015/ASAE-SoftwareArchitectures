package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ProductoEntity;

public interface ProductoRepositoryInt {
    public List<ProductoEntity> findAll();

    public ProductoEntity findById(Integer id);

    public ProductoEntity save(ProductoEntity objProducto);

    public ProductoEntity update(Integer id, ProductoEntity objProducto);

    public boolean delete(Integer id);

    public boolean existeProductoPorCodigo(String codigo);
}