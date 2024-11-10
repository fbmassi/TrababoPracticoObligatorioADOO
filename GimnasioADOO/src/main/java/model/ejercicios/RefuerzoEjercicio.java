package model.ejercicios;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RefuerzoEjercicio extends EjercicioDisponible {

    private EjercicioDisponible ejercicio;

    public RefuerzoEjercicio(GrupoMuscular grupoMuscular, int nivelAerobico, String nivelExigenciaMuscular, int series, int repeticiones, float pesoAsignado, String videoInstructivo) {
        super(grupoMuscular, nivelAerobico, nivelExigenciaMuscular, series, repeticiones, pesoAsignado, videoInstructivo);
    }

    public void agregarSeries(int series) {
        this.ejercicio.setSeries(ejercicio.getSeries() + series);
    }

    public void agregarRepeticiones(int repeticiones) {
        this.ejercicio.setRepeticiones(ejercicio.getRepeticiones() + repeticiones);
    }

    public void agregarPeso(int peso) {
        this.ejercicio.setPesoAsignado(ejercicio.getPesoAsignado() + peso);
    }
}
