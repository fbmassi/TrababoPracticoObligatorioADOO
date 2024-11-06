package model;
import dtos.EjercicioDisponibleDTO;
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

    public EjercicioDisponibleDTO toDTO() {
        EjercicioDisponibleDTO dto = new EjercicioDisponibleDTO();
        dto.setGrupoMuscular(grupoMuscular.name());
        dto.setNivelAerobico(this.nivelAerobico);
        dto.setNivelExigenciaMuscular(this.nivelExigenciaMuscular);
        dto.setSeries(this.series);
        dto.setRepeticiones(this.repeticiones);
        dto.setPesoAsignado(this.pesoAsignado);
        return dto;
    }
}
