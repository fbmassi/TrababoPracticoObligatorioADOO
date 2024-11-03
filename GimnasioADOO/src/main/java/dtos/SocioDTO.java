package dtos;
import lombok.Data;

import java.util.List;

@Data
package dtos;

import java.util.List;

@Data
public class SocioDTO {
    private int id;
    private int edad;
    private String sexoBiologico;
    private float altura;
    private EstadoFisicoDTO estadoFisico;
    private ObjetivoPrincipalDTO objetivoActual;
    private List<MedicionDTO> progreso;
    private List<TrofeoDTO> trofeos;
}