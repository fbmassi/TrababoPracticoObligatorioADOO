package model;

import dtos.DiaEntrenamientoDTO;
import dtos.RutinaDTO;
import lombok.Data;
import java.util.List;

@Data
public class Rutina {
    private List<DiaEntrenamiento> entrenamientos;
    private int duracionSemanas;
    private boolean cumplida;

    public Rutina(List<DiaEntrenamiento> entrenamientos, int duracionSemanas) {
        this.entrenamientos = entrenamientos;
        this.duracionSemanas = duracionSemanas;
        this.cumplida = false;
    }

    public void actualizarRutina(List<DiaEntrenamiento> dias) {
        this.entrenamientos = dias;
        System.out.println("Rutina actualizada con " + dias.size() + " días de entrenamiento.");
    }

    public DiaEntrenamientoDTO comenzarEntrenamientoDelDia() {
        for (DiaEntrenamiento dia : entrenamientos) {
            if (!dia.isCompletado()) {
                dia.comenzarDia();
                System.out.println("Comenzando entrenamiento del día: " + dia.getFecha());
                return dia.toDTO();
            }
        }
        System.out.println("Todos los días de entrenamiento han sido completados.");
        return null;
    }

    public void verProgresoRutina() {
        long diasCompletados = entrenamientos.stream().filter(DiaEntrenamiento::isCompletado).count();
        System.out.println("Progreso de la rutina: " + diasCompletados + "/" + entrenamientos.size() + " días completados.");
    }

    public boolean evaluarCumplimientoRutina() {
        boolean todosCompletados = entrenamientos.stream().allMatch(DiaEntrenamiento::isCompletado);
        if (todosCompletados) {
            this.cumplida = true;
            System.out.println("La rutina ha sido completada.");
        } else {
            System.out.println("La rutina aún no se ha completado.");
        }
        return this.cumplida;
    }

    public RutinaDTO toDTO() {
        RutinaDTO dto = new RutinaDTO();
        dto.setEntrenamientos(entrenamientos.stream().map(DiaEntrenamiento::toDTO).collect(Collectors.toList()));
        dto.setDuracionSemanas(this.duracionSemanas);
        dto.setCumplida(this.cumplida);
        return dto;
    }
}