package controllers;

import dtos.RutinaDTO;
import dtos.DiaEntrenamientoDTO;
import dtos.SocioDTO;
import model.Rutina;

public class RutinaController {

    private final Rutina rutina;

    public RutinaController(Rutina rutina) {
        this.rutina = rutina;
    }

    public RutinaDTO generarRutina(SocioDTO socio) {
        return rutina.generarRutina(socio);
    }

    public DiaEntrenamientoDTO comenzarEntrenamientoDelDia() {
        return rutina.comenzarEntrenamientoDelDia();
    }

    public boolean evaluarCumplimientoRutina() {
        return rutina.evaluarCumplimientoRutina();
    }
}
