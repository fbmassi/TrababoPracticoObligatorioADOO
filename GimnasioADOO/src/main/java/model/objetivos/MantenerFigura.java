package model.objetivos;

import interfaces.IObservable;
import interfaces.IObserver;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.ejercicios.*;
import model.socio.Socio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
public class MantenerFigura extends ObjetivoPrincipal {
    private float rangoPesoIdeal;

    @Override
    public void calcularRutina(Socio socio) {
        this.rangoPesoIdeal = calcularRangoPesoIdeal(socio.getPeso());

        int totalDiasRutina = 12;
        int diasPorSemana = 3;
        int duracionMinutos = 100;
        int nivelAerobico = 6;
        NivelExigencia nivelExigencia = NivelExigencia.MEDIA;

        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, totalDiasRutina, diasPorSemana,
                duracionMinutos, nivelAerobico, nivelExigencia, LocalDate.now());

        Rutina rutina = new Rutina();
        rutina.setEntrenamientos(dias);
        rutina.setDuracionDias(totalDiasRutina);
        setRutina(rutina);
    }

    @Override
    public boolean evaluarCumplimiento(Socio socio) {
        float pesoActual = socio.getPeso();
        return pesoActual >= rangoPesoIdeal - 2 && pesoActual <= rangoPesoIdeal + 2;
    }

    @Override
    public List<DiaEntrenamiento> generarDiasDeEntrenamiento(Socio socio, int totalDiasRutina, int diasPorSemana, int duracionMinutos, int nivelAerobico, NivelExigencia tipoExigencia, LocalDate fechaInicio) {
        List<DiaEntrenamiento> dias = new ArrayList<>();
        LocalDate fechaActual = fechaInicio;
        int diasGenerados = 0;
        int diasPorSemanaGenerados = 0;
        while (diasGenerados < totalDiasRutina) {
            if (fechaActual.getDayOfWeek() != DayOfWeek.SUNDAY) {
                if (diasPorSemanaGenerados < diasPorSemana) {
                    DiaEntrenamiento dia = new DiaEntrenamiento(fechaActual);
                    List<EjercicioARealizar> ejerciciosARealizar = generarEjercicios(duracionMinutos, nivelAerobico, tipoExigencia);
                    dia.setEjercicios(ejerciciosARealizar);
                    dias.add(dia);
                    diasGenerados++;
                    diasPorSemanaGenerados++;
                } else if (diasPorSemana < 4) {
                    fechaActual = fechaActual.plusDays(2);
                    diasPorSemanaGenerados = 0;
                    continue;
                }
            }
            if (fechaActual.getDayOfWeek() == DayOfWeek.SATURDAY) {
                diasPorSemanaGenerados = 0;
            }
            fechaActual = fechaActual.plusDays(1);
        }
        return dias;
    }

    @Override
    public List<EjercicioARealizar> generarEjercicios(int duracion, int nivelAerobico, NivelExigencia tipoExigencia) {
        List<EjercicioARealizar> ejercicios = new ArrayList<>();
        for (int i = 0; i < duracion / 15; i++) {
            GrupoMuscular[] grupos = GrupoMuscular.values();
            Random random = new Random();
            int randomIndex = random.nextInt(grupos.length);
            GrupoMuscular grupoMuscular = grupos[randomIndex];
            EjercicioDisponible ejercicio = new EjercicioDisponible();
            ejercicio.setGrupoMuscular(grupoMuscular);
            ejercicio.setNivelAerobico(nivelAerobico);
            ejercicio.setNivelExigenciaMuscular(tipoExigencia);
            ejercicio.setSeries(4);
            ejercicio.setRepeticiones(15);
            ejercicio.setPesoAsignado(30);
            ejercicio.setVideoInstructivo("videoEjemplo.com");
            ejercicios.add(new EjercicioARealizar(ejercicio));
        }
        return ejercicios;
    }

    private float calcularRangoPesoIdeal(float pesoInicial) {
        return pesoInicial;
    }

}