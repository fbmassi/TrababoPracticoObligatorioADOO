package model;

import dtos.SocioDTO;
import lombok.Data;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Socio {
    private int edad;
    private String sexoBiologico;
    private float altura;
    private Medicion estadoFisico;
    private ObjetivoPrincipal objetivoActual;
    private List<Medicion> progreso;
    private List<Trofeo> trofeos;

    public Socio(int edad, String sexoBiologico, float altura) {
        this.edad = edad;
        this.sexoBiologico = sexoBiologico;
        this.altura = altura;
    }

    public void setObjetivoPrincipal(objetivo ObjetivoPrincipalDTO) {

    }

    public void verEstadoFisico() {

    }

    public void autenticarse(username String, password String){

    }

    public void cerrarsesion() {

    }

    public void serNotificadoPor(trofeo Trofeo) {

    }

    public SocioDTO toDTO() {
        SocioDTO dto = new SocioDTO();
        dto.setEdad(this.edad);
        dto.setSexoBiologico(this.sexoBiologico);
        dto.setAltura(this.altura);
        dto.setEstadoFisico(this.estadoFisico);
        dto.setObjetivoActual(this.objetivoActual);
        dto.setProgreso(progreso.stream().map(Medicion::toDTO).collect(Collectors.toList()));
        dto.setTrofeos(trofeos.stream().map(Trofeo::toDTO).collect(Collectors.toList()));
        return dto;
    }

}