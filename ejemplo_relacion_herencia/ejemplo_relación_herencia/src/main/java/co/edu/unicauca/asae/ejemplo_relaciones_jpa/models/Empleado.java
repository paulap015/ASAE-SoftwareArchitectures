package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Empleado extends Persona {
    private String empresa;

    public Empleado() {
        super();
    }

    public Empleado(String nombres, String apellidos, String empresa) {
        super(nombres, apellidos);
        this.empresa = empresa;
    }

}
