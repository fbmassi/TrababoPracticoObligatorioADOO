package dtos;
import lombok.Data;
import model.ejercicios.EjercicioDisponible;

@Data
public class EjercicioARealizarDTO {
    private EjercicioDisponible ejercicio;
    private int seriesRealizadas;
    private int repeticionesRealizadas;
    private float pesoAsignado;
    private boolean completado;
}
