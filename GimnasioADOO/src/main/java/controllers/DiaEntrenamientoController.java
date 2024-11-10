package controllers;

import dtos.DiaEntrenamientoDTO;
import dtos.EjercicioARealizarDTO;
import lombok.Data;
import model.ejercicios.DiaEntrenamiento;

@Data
public class DiaEntrenamientoController {

    private final DiaEntrenamiento diaEntrenamiento;

    public DiaEntrenamientoController(DiaEntrenamiento diaEntrenamiento) {
        this.diaEntrenamiento = diaEntrenamiento;
    }

    public DiaEntrenamientoDTO comenzarDia() {
        return diaEntrenamiento.comenzarDia();
    }

    public void completarEjercicio(EjercicioARealizarDTO ejercicio) {
        diaEntrenamiento.completarEjercicio(ejercicio);
    }

    public void finalizarEntrenamiento() {
        diaEntrenamiento.finalizarEntrenamiento();
    }
}
