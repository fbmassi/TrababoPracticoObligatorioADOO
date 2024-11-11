package controllers;

import dtos.DiaEntrenamientoDTO;
import dtos.EjercicioDisponibleDTO;
import dtos.EjercicioARealizarDTO;
import dtos.RutinaDTO;
import model.ejercicios.DiaEntrenamiento;
import model.ejercicios.EjercicioARealizar;
import model.ejercicios.EjercicioDisponible;
import model.ejercicios.*;
import model.ejercicios.Rutina;

public class EjercicioController {
    private Rutina rutina;
    private DiaEntrenamiento diaEntrenamiento;
    private EjercicioARealizar ejercicioARealizar;
    private EjercicioDisponible ejercicioDisponible;

    public RutinaDTO iniciarRutina() {
        return rutina.iniciarRutina();
    }

    public RutinaDTO reforzarRutina(int series, int repeticiones, int peso) {
        return rutina.reforzarRutina(series, repeticiones, peso);
    }

    public RutinaDTO finalizarRutina() {
        return rutina.finalizarRutina();
    }

    public boolean evaluarCumplimientoRutina() {
        return rutina.verificarCumplimiento();
    }

    public DiaEntrenamientoDTO comenzarDiaEntrenamiento() {
        return diaEntrenamiento.comenzarDia();
    }

    public DiaEntrenamientoDTO finalizarDiaEntrenamiento() {
        diaEntrenamiento.finalizarEntrenamiento();
        return diaEntrenamiento.toDTO();
    }

    public EjercicioARealizarDTO guardarProgreso(int series, int repeticiones, float peso) {
        ejercicioARealizar.setSeriesRealizadas(series);
        ejercicioARealizar.setRepeticionesRealizadas(repeticiones);
        ejercicioARealizar.setPesoAsignado(peso);
        return ejercicioARealizar.toDTO();
    }

    // Marca el progreso de un ejercicio realizado y devuelve su DTO
    public EjercicioARealizarDTO marcarCompletado() {
        return ejercicioARealizar.marcarCompletado();
    }

    public EjercicioDisponibleDTO crearEjercicio(GrupoMuscular grupoMuscular, int nivelAerobico, NivelExigencia nivelExigencia,
                                              int series, int repeticiones, float pesoAsignado, String videoInstructivo) {
        return ejercicioDisponible.crearEjercicio(grupoMuscular, nivelAerobico, nivelExigencia,
                                            series, repeticiones, pesoAsignado, videoInstructivo);
    }

    public EjercicioDisponibleDTO verVideoInstructivo(EjercicioDisponible ejercicio) {
        ejercicio.verVideoInstructivo();
        return ejercicio.toDTO();
    }
}