package model;

import dtos.SocioDTO;

public class TonificarCuerpo extends ObjetivoPrincipal {
    private float nivelMasaMuscularIdeal;
    private float porcentajeGrasaIdeal;

    @Override
    public Rutina calcularRutina(SocioDTO socio) {
        // Lógica para calcular la rutina de tonificar cuerpo
        return null;
    }

    @Override
    public boolean evaluarCumplimiento(SocioDTO socio) {
        // Lógica para evaluar cumplimiento
        return false;
    }
}
