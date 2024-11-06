package controllers;

import dtos.DiaEntrenamientoDTO;
import dtos.EjercicioRealizadoDTO;
import lombok.Data;
import model.DiaEntrenamiento;

@Data
public class DiaEntrenamientoController {

    private final DiaEntrenamiento diaEntrenamiento;

    public DiaEntrenamientoController(DiaEntrenamiento diaEntrenamiento) {
        this.diaEntrenamiento = diaEntrenamiento;
    }

    public DiaEntrenamientoDTO comenzarDia() {
        return diaEntrenamiento.comenzarDia();
    }

    public void completarEjercicio(EjercicioRealizadoDTO ejercicio) {
        diaEntrenamiento.completarEjercicio(ejercicio);
    }

    public void finalizarEntrenamiento() {
        diaEntrenamiento.finalizarEntrenamiento();
    }
}
