package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ProductoEntity;

@Repository
public class ProductoRepositoryImpl implements ProductoRepositoryInt {

    private ArrayList<ProductoEntity> listaDeProductos;

    public ProductoRepositoryImpl() {
        this.listaDeProductos = new ArrayList<ProductoEntity>();
        this.cargarProductos();
    }

    @Override
    public List<ProductoEntity> findAll() {
        System.out.println("Invocando a listar productos");
        return this.listaDeProductos;
    }

    @Override
    public ProductoEntity findById(Integer id) {
        System.out.println("Invocando a consultar un producto");
        ProductoEntity objProductoR = null;

        for (ProductoEntity objProductoE : this.listaDeProductos) {
            if (objProductoE.getId() == id) {
                objProductoR = objProductoE;
                break;
            }
        }

        return objProductoR;
    }

    @Override
    public ProductoEntity save(ProductoEntity objProducto) {
        System.out.println("Invocando a almacenar producto");
        ProductoEntity objProductoR = null;
        if (this.listaDeProductos.add(objProducto)) {
            objProductoR = objProducto;
        }

        return objProductoR;
    }

    @Override
    public ProductoEntity update(Integer id, ProductoEntity objProducto) {
        System.out.println("Invocando a actualizar un producto");
        ProductoEntity objProductoR = null;

        for (int i = 0; i < this.listaDeProductos.size(); i++) {
            if (this.listaDeProductos.get(i).getId() == id) {
                this.listaDeProductos.set(i, objProducto);
                objProductoR = objProducto;
                break;
            }
        }

        return objProductoR;
    }

    @Override
    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un producto");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeProductos.size(); i++) {
            if (this.listaDeProductos.get(i).getId() == id) {
                this.listaDeProductos.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarProductos() {
        ProductoEntity objProducto1 = new ProductoEntity(1, "0145", "Dolex", 'm', 200, new Date());
        this.listaDeProductos.add(objProducto1);
        ProductoEntity objProducto2 = new ProductoEntity(2, "0829", "Advil", 'm', 500, new Date());
        this.listaDeProductos.add(objProducto2);
        ProductoEntity objProducto3 = new ProductoEntity(3, "1932", "Arroz", 'a', 3500, new Date());
        this.listaDeProductos.add(objProducto3);
        ProductoEntity objProducto4 = new ProductoEntity(4, "2085", "Lapiz", 'p', 2000, new Date());
        this.listaDeProductos.add(objProducto4);
    }

    @Override
    public boolean existeProductoPorCodigo(String codigo) {
        System.out.println("Invocando a buscar si existe un producto");
        boolean bandera = false;
        for (int i = 0; i < this.listaDeProductos.size(); i++) {
            if (this.listaDeProductos.get(i).getCodigo().compareTo(codigo) == 0) {
                bandera = true;
                break;
            }
        }
        return bandera;
    }

}