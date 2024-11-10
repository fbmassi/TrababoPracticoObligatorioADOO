package controllers;

import lombok.Data;
import model.ejericios.EjercicioDisponible;

@Data
public class EjercicioDisponibleController {

    private final EjercicioDisponible ejercicio;

    public EjercicioDisponibleController(EjercicioDisponible ejercicioService) {
        this.ejercicio = ejercicioService;
    }

}