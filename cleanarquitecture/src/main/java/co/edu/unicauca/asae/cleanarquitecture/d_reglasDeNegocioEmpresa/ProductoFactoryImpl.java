package co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa;

public class ProductoFactoryImpl implements ProductoFactoryInt {

    @Override
    public Producto crear(int id, String codigo, String nombre, char tipo, float valor) {
        return new Producto(id, codigo, nombre, tipo, valor, null);
    }

}