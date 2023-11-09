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
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Animal {
    @Id
    private int idAnimal;
    private String especie;

    public Animal(int idAnimal)
    {
        this.idAnimal=idAnimal;
    }
}
