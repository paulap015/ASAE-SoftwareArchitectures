package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estudiante extends Persona {
    private float promedio;

    public Estudiante() {
        super();
    }

    public Estudiante(String nombres, String apellidos, float promedio) {
        super(nombres, apellidos);
        this.promedio = promedio;
    }

}