package dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DiaEntrenamientoDTO {
    private LocalDate fecha;
    private List<EjercicioDisponibleDTO> ejercicios;
    private boolean completado;
}
