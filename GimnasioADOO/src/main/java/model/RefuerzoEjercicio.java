package model;

public class RefuerzoEjercicio extends EjercicioDisponible {
    private EjercicioDisponible ejercicio;

    public void agregarSeries(int series) {
        this.ejercicio.series += series;
    }

    public void agregarRepeticiones(int repeticiones) {
        this.ejercicio.repeticiones += repeticiones;
    }

    public void agregarPeso(int peso) {
        this.ejercicio.pesoAsignado += peso;
    }
}
