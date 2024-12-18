package model.objetivos;

import interfaces.IObservable;
import interfaces.IObserver;
import lombok.Data;
import model.ejercicios.*;
import model.socio.Socio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class ObjetivoPrincipal {
    private int diasEntrenamiento;
    private int duracionEntrenamiento;
    private Rutina rutina;

    public abstract void calcularRutina(Socio socio);

    public abstract boolean evaluarCumplimiento(Socio socio);

    public abstract List<DiaEntrenamiento> generarDiasDeEntrenamiento(Socio socio, int totalDiasRutina, int diasPorSemana,
                                                             int duracionMinutos, int nivelAerobico, NivelExigencia nivelExigencia,
                                                             LocalDate fechaInicio);


    public abstract List<EjercicioARealizar> generarEjercicios(int duracion, int nivelAerobico, NivelExigencia tipoExigencia);
}