package model;

import dtos.MedicionDTO;
import dtos.SocioDTO;

import java.util.Date;

public class Medicion {
    private float peso;
    private float masaMuscular;
    private float porcentajeGrasaCorporal;
    private Date fecha;
    private IMedidorAdapter medidor;

    public String verEstadoFisico(SocioDTO socio) {

    }

    public void registrarMedicion() {

    }

    public void medirPeso() {

    }

    public float medirMasaMuscular() {

    }

    public float medirGrasaCorporal() {

    }

    public MedicionDTO toDTO() {
        MedicionDTO dto = new MedicionDTO();
        dto.setPeso(this.peso);
        dto.setMasaMuscular(this.masaMuscular);
        dto.setPorcentajeGrasaCorporal(this.porcentajeGrasaCorporal);
        dto.setFecha(this.fecha);
        dto.setMedidor(this.medidor);
        return dto;
    }
}
