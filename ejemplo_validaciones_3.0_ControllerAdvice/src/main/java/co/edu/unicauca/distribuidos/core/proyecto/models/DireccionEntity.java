package co.edu.unicauca.distribuidos.core.proyecto.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Direcciones")
public class DireccionEntity {

	@Id
	private Integer idUsuario;
	private String calle;
	private String ciudad;
	private String pais;

	@OneToOne(optional = false)
	@MapsId
	@JoinColumn(name = "idUsuario", nullable = false)
	private ClienteEntity objUsuario;

}
