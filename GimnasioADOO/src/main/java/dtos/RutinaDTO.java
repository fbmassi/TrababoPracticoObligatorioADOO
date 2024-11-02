package dtos;
import lombok.Data;

import java.util.List;

@Data
public class RutinaDTO {
    private List<DiaEntrenamientoDTO> entrenamientos;
    private int duracionSemanas;
    private boolean cumplida;
}
