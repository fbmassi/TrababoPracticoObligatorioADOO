package dtos;
import lombok.Data;
import model.ejercicios.Estado;

import java.util.List;

@Data
public class RutinaDTO {
    private List<DiaEntrenamientoDTO> entrenamientos;
    private int duracionSemanas;
    private Estado estado;
}
