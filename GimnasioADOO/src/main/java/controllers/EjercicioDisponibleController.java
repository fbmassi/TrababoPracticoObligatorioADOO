package controllers;

import lombok.Data;
import model.ejercicios.EjercicioDisponible;

@Data
public class EjercicioDisponibleController {

    private final EjercicioDisponible ejercicio;

    public EjercicioDisponibleController(EjercicioDisponible ejercicioService) {
        this.ejercicio = ejercicioService;
    }

}