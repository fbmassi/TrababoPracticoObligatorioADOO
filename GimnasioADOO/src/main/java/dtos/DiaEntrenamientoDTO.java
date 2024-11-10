package dtos;

import lombok.Data;
import model.ejercicios.EjercicioARealizar;
import model.ejercicios.Estado;

import java.time.LocalDate;
import java.util.List;

@Data
public class DiaEntrenamientoDTO {
    private LocalDate fecha;
    private List<EjercicioARealizarDTO> ejercicios;
    private Estado estado;
}
