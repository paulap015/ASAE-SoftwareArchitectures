package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "IdPerro")
@Getter @Setter @NoArgsConstructor
public class Perro extends Animal{
    private String nombre;

    public Perro(int idAnimal, String especie,String nombre)
    {
        super(idAnimal, especie);
        this.nombre=nombre;
    }
}
