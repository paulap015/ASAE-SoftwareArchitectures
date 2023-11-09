package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Libro extends Producto{
    private String autor;

    public Libro(int idProducto, String nombre, String autor)
    {
        super(idProducto, nombre);
        this.autor=autor;
    }
}
