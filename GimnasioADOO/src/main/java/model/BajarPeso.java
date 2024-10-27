package model;

import dtos.SocioDTO;

public class BajarPeso extends ObjetivoPrincipal {
    private float pesoIdeal;

    @Override
    public Rutina calcularRutina(SocioDTO socio) {
        // Lógica para calcular la rutina de bajar peso
        return null;
    }

    @Override
    public boolean evaluarCumplimiento(SocioDTO socio) {
        // Lógica para evaluar cumplimiento
        return false;
    }
}
