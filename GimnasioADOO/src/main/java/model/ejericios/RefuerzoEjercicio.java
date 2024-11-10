package model.ejericios;
import lombok.Data;

@Data
public class RefuerzoEjercicio extends EjercicioDisponible {
    private EjercicioDisponible ejercicio;

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
