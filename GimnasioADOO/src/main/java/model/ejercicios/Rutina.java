package model.ejercicios;

import dtos.RutinaDTO;
import interfaces.IObservable;
import interfaces.IObserver;
import lombok.Data;
import model.socio.Socio;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Rutina {
    private List<DiaEntrenamiento> entrenamientos;
    private int duracionDias;
    private Estado estado;

    public Rutina() {
        this.estado = Estado.NO_INICIADO;
    }

    public static Rutina crearRutina() {
        return new Rutina();
    }

    public RutinaDTO iniciarRutina() {
        this.estado = Estado.INICIADO;
        return this.toDTO();
    }

    public RutinaDTO reforzarRutina(int series, int repeticiones, int peso) {
        for (DiaEntrenamiento dia : entrenamientos) {
            for (EjercicioARealizar ejercicio : dia.getEjercicios()) {
                EjercicioDisponible ejercicioDisponible = ejercicio.getEjercicio();
                RefuerzoEjercicio refuerzo = getRefuerzoEjercicio(series, ejercicio, ejercicioDisponible);
                refuerzo.agregarRepeticiones(repeticiones);
                refuerzo.agregarPeso(peso);
                ejercicio.setEjercicio(refuerzo);
            }
        }
        System.out.println("Rutina reforzada.");
        return this.toDTO();
    }

    private static RefuerzoEjercicio getRefuerzoEjercicio(int series, EjercicioARealizar ejercicio, EjercicioDisponible ejercicioDisponible) {
        RefuerzoEjercicio refuerzo = new RefuerzoEjercicio(ejercicio.getEjercicio().getGrupoMuscular(),
                                            ejercicioDisponible.getNivelAerobico(),
                                            ejercicioDisponible.getNivelExigenciaMuscular(),
                                            ejercicioDisponible.getSeries(),
                                            ejercicioDisponible.getRepeticiones(),
                                            ejercicioDisponible.getPesoAsignado(),
                                            ejercicioDisponible.getVideoInstructivo());
        refuerzo.agregarSeries(series);
        return refuerzo;
    }

    public RutinaDTO finalizarRutina() {
        this.estado = Estado.FINALIZADO;
        System.out.println("La rutina ha sido finalizada.");
        return this.toDTO();
    }

    public RutinaDTO toDTO() {
        RutinaDTO dto = new RutinaDTO();
        dto.setEntrenamientos(entrenamientos.stream().map(DiaEntrenamiento::toDTO).collect(Collectors.toList()));
        dto.setDuracionSemanas(this.duracionDias);
        return dto;
    }

    public boolean verificarCumplimiento() {
        int diasAsistidos = 0;
        int totalDias = 0;
        List<DiaEntrenamiento> diasEtrenamiento = getEntrenamientos();
        for (DiaEntrenamiento diaEntrenamiento : diasEtrenamiento) {
            totalDias++;
            if (diaEntrenamiento.getEstado().equals(Estado.INICIADO)
                    || diaEntrenamiento.getEstado().equals(Estado.FINALIZADO)) {
                diasAsistidos++;
            }
        }
        return diasAsistidos == totalDias;
    }

}