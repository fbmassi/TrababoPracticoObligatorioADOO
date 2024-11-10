package model.ejericios;
import lombok.Data;

@Data
public class EjercicioRealizado {
    private EjercicioDisponible ejercicioARealizar;
    private int seriesRealizadas;
    private int repeticionesRealizadas;
    private float pesoAsignado;
    private DiaEntrenamiento diaEntrenamiento;

    public EjercicioRealizado(EjercicioDisponible ejercicioARealizar, DiaEntrenamiento diaEntrenamiento) {
        this.ejercicioARealizar = ejercicioARealizar;
        this.diaEntrenamiento = diaEntrenamiento;
        this.seriesRealizadas = 0;
        this.repeticionesRealizadas = 0;
        this.pesoAsignado = ejercicioARealizar.getPesoAsignado(); // Asigna el peso base del ejercicio
    }

    public void guardarProgreso(int series, int repeticiones, float peso) {
        // Guardar el progreso de un ejercicio realizado
        this.seriesRealizadas = series;
        this.repeticionesRealizadas = repeticiones;
        this.pesoAsignado = peso;
        System.out.println("Progreso guardado: " + series + " series, " + repeticiones + " repeticiones, peso: " + peso + "kg.");
    }

    public boolean verificarCumplimiento() {
        // Verificar si el ejercicio se completó según los objetivos de series, repeticiones y peso
        return seriesRealizadas >= ejercicioARealizar.getSeries() &&
                repeticionesRealizadas >= ejercicioARealizar.getRepeticiones() &&
                pesoAsignado >= ejercicioARealizar.getPesoAsignado();
    }
}
