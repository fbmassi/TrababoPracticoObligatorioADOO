package dtos;
import lombok.Data;
import model.ejercicios.GrupoMuscular;

@Data
public class EjercicioDisponibleDTO {
    private GrupoMuscular grupoMuscular;
    private int nivelAerobico;
    private String nivelExigenciaMuscular;
    private int series;
    private int repeticiones;
    private float pesoAsignado;
    private String videoInstructivo;
}
