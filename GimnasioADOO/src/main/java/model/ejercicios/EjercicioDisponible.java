package model.ejercicios;
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

    public EjercicioDisponible(GrupoMuscular grupoMuscular, int nivelAerobico, String nivelExigenciaMuscular, int series, int repeticiones, float pesoAsignado, String videoInstructivo) {
        this.grupoMuscular = grupoMuscular;
        this.nivelAerobico = nivelAerobico;
        this.nivelExigenciaMuscular = nivelExigenciaMuscular;
        this.series = series;
        this.repeticiones = repeticiones;
        this.pesoAsignado = pesoAsignado;
        this.videoInstructivo = videoInstructivo;
    }

    public EjercicioDisponible() {
    }

    public static EjercicioDisponible crearEjercicio(GrupoMuscular grupoMuscular, int nivelAerobico, String nivelExigenciaMuscular, int series, int repeticiones, float pesoAsignado, String videoInstructivo) {
        return new EjercicioDisponible(grupoMuscular, nivelAerobico, nivelExigenciaMuscular, series, repeticiones, pesoAsignado, videoInstructivo);
    }

    public EjercicioDisponibleDTO toDTO() {
        EjercicioDisponibleDTO dto = new EjercicioDisponibleDTO();
        dto.setGrupoMuscular(this.grupoMuscular);
        dto.setNivelAerobico(this.nivelAerobico);
        dto.setNivelExigenciaMuscular(this.nivelExigenciaMuscular);
        dto.setSeries(this.series);
        dto.setRepeticiones(this.repeticiones);
        dto.setPesoAsignado(this.pesoAsignado);
        dto.setVideoInstructivo(this.videoInstructivo);
        return dto;
    }

    public void verVideoInstructivo() {
        System.out.println(videoInstructivo);
    }

}
