package dtos;
import lombok.Data;

@Data
public class EjercicioDisponibleDTO {
    private String grupoMuscular;
    private int nivelAerobico;
    private String nivelExigenciaMuscular;
    private int series;
    private int repeticiones;
    private float pesoAsignado;
}
