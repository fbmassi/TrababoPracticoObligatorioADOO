package model.objetivos;

import dtos.SocioDTO;
import interfaces.IObserver;
import lombok.Data;
import model.ejericios.Rutina;
import model.ejericios.DiaEntrenamiento;
import model.ejericios.EjercicioDisponible;
import model.socio.Socio;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class ObjetivoPrincipal {
    private int diasEntrenamiento;
    private int duracionEntrenamiento;
    private Rutina rutina;
    private List<IObserver> observadores;

    public abstract Rutina calcularRutina(Socio socio);
    public abstract boolean evaluarCumplimiento(Socio socio);

    public List<DiaEntrenamiento> generarDiasDeEntrenamiento(Socio socio, int diasSemana, int duracionMinutos, int nivelAerobico, String tipoExigencia) {
        List<DiaEntrenamiento> dias = new ArrayList<>();
        for (int i = 0; i < diasSemana; i++) {
            DiaEntrenamiento dia = new DiaEntrenamiento();
            dia.setEjercicios(generarEjercicios(duracionMinutos, nivelAerobico, tipoExigencia));
            dias.add(dia);
        }
        return dias;
    }

    public List<EjercicioDisponible> generarEjercicios(int duracion, int nivelAerobico, String tipoExigencia) {
        List<EjercicioDisponible> ejercicios = new ArrayList<>();
        for (int i = 0; i < duracion / 15; i++) {
            EjercicioDisponible ejercicio = new EjercicioDisponible();
            ejercicio.setNivelAerobico(nivelAerobico);
            ejercicio.setNivelExigenciaMuscular(tipoExigencia);
            ejercicio.setSeries(3);
            ejercicio.setRepeticiones(12);
            ejercicio.setPesoAsignado(20);
            ejercicios.add(ejercicio);
        }
        return ejercicios;
    }

}
