package dtos;

import lombok.Data;
import java.util.List;

@Data
public class SocioDTO {
    private Integer edad;
    private String sexoBiologico;
    private Float altura;
    private Medicion estadoFisico;
    private ObjetivoPrincipal objetivoActual;
    private List<Medicion> progreso;
    private List<Trofeo> trofeos;
}