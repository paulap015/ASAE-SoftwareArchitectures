package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SolicitudDTO{
   
    private Integer id;
    private Date fecha;
    private String archivo;
    private String comentarios;
}
