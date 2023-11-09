package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DireccionDTO {
	
	private Integer id;
	private String calle;
	private String ciudad;
	private String pais;	
}
