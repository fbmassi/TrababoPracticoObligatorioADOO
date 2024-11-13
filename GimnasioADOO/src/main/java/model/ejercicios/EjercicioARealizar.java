package model.ejercicios;
import dtos.EjercicioARealizarDTO;
import lombok.Data;

@Data
public class EjercicioARealizar {
    private EjercicioDisponible ejercicio;
    private int seriesRealizadas;
    private int repeticionesRealizadas;
    private float pesoAsignado;
    private boolean completado;

    public EjercicioARealizar(EjercicioDisponible ejercicio) {
        this.ejercicio = ejercicio;
        this.seriesRealizadas = 0;
        this.repeticionesRealizadas = 0;
        this.pesoAsignado = ejercicio.getPesoAsignado();
        this.completado = false;
    }

    public EjercicioARealizarDTO marcarCompletado() {
        this.completado = true;
        return this.toDTO();
    }

    public EjercicioARealizarDTO toDTO() {
        EjercicioARealizarDTO dto = new EjercicioARealizarDTO();
        dto.setEjercicio(this.ejercicio);
        dto.setSeriesRealizadas(this.seriesRealizadas);
        dto.setRepeticionesRealizadas(this.repeticionesRealizadas);
        dto.setPesoAsignado(this.pesoAsignado);
        dto.setCompletado(this.completado);
        return dto;
    }
}
