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
public class BajarPeso extends ObjetivoPrincipal {
    private float pesoIdeal;

    @Override
    public void calcularRutina(Socio socio) {
        this.pesoIdeal = calcularPesoIdeal(socio);
        int totalDiasRutina = 8;
        int diasPorSemana = 3;
        int duracionMinutos = 60;
        int nivelAerobico = 8;
        NivelExigencia nivelExigencia = NivelExigencia.MEDIA;

        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, totalDiasRutina, diasPorSemana,
                duracionMinutos, nivelAerobico, nivelExigencia, LocalDate.now());

        Rutina rutina = new Rutina();
        rutina.setEntrenamientos(dias);
        rutina.setDuracionDias(totalDiasRutina);
        rutina.setObservadores(getObservadores());
        setRutina(rutina);
    }

    @Override
    public void evaluarCumplimiento(Socio socio) {
        if (socio.getPeso() <= pesoIdeal) {
            for (IObserver observador : observadores) {
                observador.serNotifocadoPor(socio);
            }
        }
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
                    Random random = new Random();
                    dia.setEjercicios(generarEjercicios(GrupoMuscular.values()[random.nextInt(GrupoMuscular.values().length)],
                            duracionMinutos, nivelAerobico, tipoExigencia));
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
    public List<EjercicioARealizar> generarEjercicios(GrupoMuscular grupoMuscular, int duracion, int nivelAerobico, NivelExigencia tipoExigencia) {
        List<EjercicioARealizar> ejercicios = new ArrayList<>();
        for (int i = 0; i < duracion / 15; i++) {
            EjercicioDisponible ejercicio = new EjercicioDisponible();
            ejercicio.setNivelAerobico(nivelAerobico);
            ejercicio.setNivelExigenciaMuscular(tipoExigencia);
            ejercicio.setSeries(3);
            ejercicio.setRepeticiones(12);
            ejercicio.setPesoAsignado(20);
            ejercicios.add(new EjercicioARealizar(ejercicio));
        }
        return ejercicios;
    }

    private float calcularPesoIdeal(Socio socio) {
        float altura = socio.getAltura() / 100;
        return socio.getSexoBiológico().equals("M") ? 22 * (altura * altura) : 21 * (altura * altura);
    }

    public void notificarObservadores() {
        for (IObserver observador : observadores) {
            observador.serNotifocadoPor(this);
        }
    }

    public void agregarObservador(IObserver o) {
        observadores.add(o);
    }

    public void eliminarObservador(IObserver o) {
        observadores.remove(o);
    }

}