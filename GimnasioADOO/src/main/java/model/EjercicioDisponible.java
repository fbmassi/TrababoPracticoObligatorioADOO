package model;
import lombok.Data;

@Data
public class EjercicioDisponible {
    private GrupoMuscular grupoMuscular;
    private int nivelAerobico;
    private String nivelExigenciaMuscular;
    private int series;
    private int repeticiones;
    private float pesoAsignado;
    private String videoInstructivo;


    public void verVideoInstructivo() {
        System.out.println(videoInstructivo);
    }

}
