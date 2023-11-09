package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Solicitudes")
public class Solicitud {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String archivo;
    private String comentarios;

    @ManyToOne
    @JoinColumn(name="idUsuario", nullable=false)
    private Usuario objUsuario;

            
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
       
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return String return the archivo
     */
    public String getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    /**
     * @return String return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return Usuario return the objUsuario
     */
    public Usuario getObjUsuario() {
        return objUsuario;
    }

    /**
     * @param objUsuario the objUsuario to set
     */
    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

   
}
