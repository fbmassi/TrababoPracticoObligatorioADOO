package controllers;

import dtos.DiaEntrenamientoDTO;
import dtos.EjercicioRealizadoDTO;
import lombok.Data;
import model.DiaEntrenamiento;

@Data
public class DiaEntrenamientoController {

    private DiaEntrenamiento diaEntrenamientoService;

    public DiaEntrenamientoController(DiaEntrenamiento diaEntrenamientoService) {
        this.diaEntrenamientoService = diaEntrenamientoService;
    }

    public DiaEntrenamientoDTO comenzarDia() {
        return diaEntrenamientoService.comenzarDia();
    }

    public void completarEjercicio(EjercicioRealizadoDTO ejercicio) {
        diaEntrenamientoService.completarEjercicio(ejercicio);
    }

    public void finalizarEntrenamiento() {
        diaEntrenamientoService.finalizarEntrenamiento();
    }
}
