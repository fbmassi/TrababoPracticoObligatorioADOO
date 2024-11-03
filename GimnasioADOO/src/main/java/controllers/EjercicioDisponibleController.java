package controllers;

import dtos.EjercicioDisponibleDTO;
import model.EjercicioDisponible;


public class EjercicioDisponibleController {

    private EjercicioDisponible ejercicio;

    public EjercicioDisponibleController(EjercicioDisponible ejercicioService) {
        this.ejercicio = ejercicioService;
    }

}
