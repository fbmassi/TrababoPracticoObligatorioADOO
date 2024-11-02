package dtos;
import lombok.Data;

@Data
public class EjercicioRealizadoDTO {
    private EjercicioDisponibleDTO ejercicioARealizar;
    private int seriesRealizadas;
    private int repeticionesRealizadas;
    private float pesoAsignado;
    private DiaEntrenamientoDTO diaEntrenamiento;
}
