package model;

import dtos.SocioDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class ObjetivoPrincipal {
    protected int diasEntrenamiento;
    protected int duracionEntrenamiento;

    public abstract Rutina calcularRutina(SocioDTO socio);
    public abstract boolean evaluarCumplimiento(SocioDTO socio);

    protected List<DiaEntrenamiento> generarDiasDeEntrenamiento(SocioDTO socio, int diasSemana, int duracionMinutos, int nivelAerobico, String tipoExigencia) {
        List<DiaEntrenamiento> dias = new ArrayList<>();
        for (int i = 0; i < diasSemana; i++) {
            DiaEntrenamiento dia = new DiaEntrenamiento();
            dia.setEjercicios(generarEjercicios(duracionMinutos, nivelAerobico, tipoExigencia));
            dias.add(dia);
        }
        return dias;
    }

    protected List<EjercicioDisponible> generarEjercicios(int duracion, int nivelAerobico, String tipoExigencia) {
        // Genera ejercicios con las especificaciones indicadas (nivel aeróbico, exigencia)
        List<EjercicioDisponible> ejercicios = new ArrayList<>();
        // Ejemplo de lógica para agregar ejercicios según criterios
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
