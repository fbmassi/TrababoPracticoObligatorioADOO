package model;

import lombok.Data;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class DiaEntrenamiento {
    private List<EjercicioDisponible> ejercicios;
    private boolean completado;
    private LocalDate fecha;

    public DiaEntrenamiento() {
        this.fecha = LocalDate.now(); // Fecha actual del día de entrenamiento
        this.completado = false;
    }

    public void comenzarDia() {
        // Iniciar el entrenamiento del día, marcando los ejercicios como pendientes
        System.out.println("Entrenamiento del día iniciado: " + fecha);
        this.completado = false;
    }

    public void completarEjercicio(EjercicioDisponible ejercicio) {
        // Marcar un ejercicio específico como completado
        // Aquí podríamos tener una lógica que busque el ejercicio en la lista y lo actualice
        if (ejercicios.contains(ejercicio)) {
            System.out.println("Ejercicio completado: " + ejercicio);
            ejercicio.verVideoInstructivo(); // Mostrar video instructivo opcionalmente
        } else {
            System.out.println("Ejercicio no encontrado en la lista de hoy.");
        }
    }

    public void guardarRegistroDia() {
        // Guardar el registro del día actual (esto podría interactuar con una base de datos)
        System.out.println("Registro del día guardado: " + fecha);
    }

    public void finalizarEntrenamiento() {
        // Finalizar el entrenamiento del día y marcar como completado
        this.completado = true;
        guardarRegistroDia(); // Guardar el registro al finalizar
        System.out.println("Entrenamiento finalizado.");
    }
}