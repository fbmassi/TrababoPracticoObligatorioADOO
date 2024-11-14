package model.ejercicios;

import dtos.DiaEntrenamientoDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Data
public class DiaEntrenamiento {
    private List<EjercicioARealizar> ejercicios;
    private LocalDate fecha;
    private Estado estado;

    public DiaEntrenamiento(LocalDate fecha) {
        this.fecha = fecha;
        this.estado = Estado.NO_INICIADO;
    }

    public DiaEntrenamientoDTO comenzarDia() {
        this.estado = Estado.INICIADO;
        System.out.println("Entrenamiento del día iniciado: " + fecha);
        return this.toDTO();
    }

    public void finalizarEntrenamiento() {
        this.estado = Estado.FINALIZADO;
        System.out.println("Entrenamiento del día finalizado.");
    }

    public DiaEntrenamientoDTO toDTO() {
        DiaEntrenamientoDTO dto = new DiaEntrenamientoDTO();
        dto.setFecha(this.fecha);
        dto.setEstado(estado);
        dto.setEjercicios(ejercicios.stream().map(EjercicioARealizar::toDTO).collect(Collectors.toList()));
        return dto;
    }
}