package model;

import java.util.List;

public class Rutina {
    private List<DiaEntrenamiento> entrenamientos;
    private int duracionSemanas;
    private boolean cumplida;

    public void actualizarRutina(List<DiaEntrenamiento> dias) {
        this.entrenamientos = dias;
    }

    public DiaEntrenamiento comenzarEntrenamientoDelDia() {
        // Lógica para iniciar el entrenamiento del día
        return null;
    }

    public void verProgresoRutina() {
        // Lógica para mostrar el progreso de la rutina
    }

    public boolean evaluarCumplimientoRutina() {
        // Lógica para evaluar el cumplimiento de la rutina
        return false;
    }
}