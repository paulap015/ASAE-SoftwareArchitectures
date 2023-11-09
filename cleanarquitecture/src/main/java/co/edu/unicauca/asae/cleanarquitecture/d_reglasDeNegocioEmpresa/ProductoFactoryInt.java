package co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa;

public interface ProductoFactoryInt {
    public Producto crear(int id, String codigo, String nombre, char tipo, float valor);
}