package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Lapiz extends Producto{
    private String color;

    public Lapiz(int idProducto, String nombre,String color)
    {
        super(idProducto, nombre);
        this.color=color;
    }
}
