package controllers;

import dtos.EjercicioDisponibleDTO;
import lombok.Data;
import model.EjercicioDisponible;

@Data
public class EjercicioDisponibleController {

    private final EjercicioDisponible ejercicio;

    public EjercicioDisponibleController(EjercicioDisponible ejercicioService) {
        this.ejercicio = ejercicioService;
    }

}