package model;

import dtos.SocioDTO;

public abstract class ObjetivoPrincipal {
    protected int diasEntrenamiento;
    protected int duracionEntrenamiento;

    public abstract Rutina calcularRutina(SocioDTO socio);
    public abstract boolean evaluarCumplimiento(SocioDTO socio);
}
