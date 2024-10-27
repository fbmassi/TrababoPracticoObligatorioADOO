package model;

import dtos.SocioDTO;

public class MantenerFigura extends ObjetivoPrincipal {
    private float rangoPesoIdeal;

    @Override
    public Rutina calcularRutina(SocioDTO socio) {
        // Lógica para calcular la rutina de mantener figura
        return null;
    }

    @Override
    public boolean evaluarCumplimiento(SocioDTO socio) {
        // Lógica para evaluar cumplimiento
        return false;
    }
}
