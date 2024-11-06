package model;

import dtos.DiaEntrenamientoDTO;
import dtos.EjercicioDisponibleDTO;
import dtos.EjercicioRealizadoDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DiaEntrenamiento {
    private List<EjercicioDisponible> ejercicios;
    private boolean completado;
    private LocalDate fecha;

    public DiaEntrenamiento() {
        this.fecha = LocalDate.now(); // Fecha actual del día de entrenamiento
        this.completado = false;
    }

    public DiaEntrenamientoDTO comenzarDia() {
        System.out.println("Entrenamiento del día iniciado: " + fecha);
        this.completado = false;
        return this.toDTO();
    }

    public void completarEjercicio(EjercicioRealizadoDTO ejercicioDTO) {
        boolean encontrado = false;

        for (EjercicioDisponible ejercicio : ejercicios) {
            if (ejercicio.getGrupoMuscular().equals(ejercicioDTO.getGrupoMuscular()) &&
                    ejercicio.getNivelAerobico() == ejercicioDTO.getNivelAerobico() &&
                    ejercicio.getNivelExigenciaMuscular().equals(ejercicioDTO.getNivelExigenciaMuscular()) &&
                    ejercicio.getSeries() == ejercicioDTO.getSeries() &&
                    ejercicio.getRepeticiones() == ejercicioDTO.getRepeticiones() &&
                    ejercicio.getPesoAsignado() == ejercicioDTO.getPesoAsignado() &&
                    ejercicio.getVideoInstructivo().equals(ejercicioDTO.getVideoInstructivo())) {

                System.out.println("Ejercicio completado: " + ejercicioDTO);
                ejercicio.verVideoInstructivo();
                encontrado = true;
                break;
            }
        }

        // Si no se encontró el ejercicio, mostrar el mensaje
        if (!encontrado) {
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

    public DiaEntrenamientoDTO toDTO() {
        DiaEntrenamientoDTO dto = new DiaEntrenamientoDTO();
        dto.setFecha(this.fecha);
        dto.setEjercicios(ejercicios.stream().map(EjercicioDisponible::toDTO).collect(Collectors.toList()));
        dto.setCompletado(this.completado);
        return dto;
    }
}