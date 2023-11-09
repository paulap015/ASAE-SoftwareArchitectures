package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoEntity {
    private int id;
    private String codigo;
    private String nombre;
    private char tipo;
    private float valor;
    private Date createAt;

    public ProductoEntity() {

    }
}