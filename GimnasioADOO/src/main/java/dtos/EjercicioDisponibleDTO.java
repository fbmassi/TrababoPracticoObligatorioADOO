package dtos;
import lombok.Data;
import model.ejercicios.GrupoMuscular;
import model.ejercicios.NivelExigencia;

@Data
public class EjercicioDisponibleDTO {
    private GrupoMuscular grupoMuscular;
    private int nivelAerobico;
    private NivelExigencia nivelExigenciaMuscular;
    private int series;
    private int repeticiones;
    private float pesoAsignado;
    private String videoInstructivo;
}
