package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Producto {
    @Id
    private int idProducto;
    private String nombre;
}
