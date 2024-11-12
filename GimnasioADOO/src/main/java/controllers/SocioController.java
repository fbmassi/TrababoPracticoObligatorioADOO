package controllers;

import dtos.SocioDTO;
import lombok.Data;
import model.socio.Socio;
import model.objetivos.ObjetivoPrincipal;

@Data
public class SocioController {

    private Socio socio;

    public SocioController(Socio socio) {
        this.socio = socio;
    }

    public SocioDTO setObjetivoPrincipal(ObjetivoPrincipal objetivo) {
        return socio.setObjetivoPrincipal(objetivo);
    }

    public SocioDTO medirEstadoFisico() {
        return socio.medirEstadoFisico();
    }

    public SocioDTO autenticarse(String username, String contraseña) {
        return socio.autenticarse(username, contraseña);
    }

    public SocioDTO cerrarSesion(SocioDTO socioDTO) {
        SocioDTO socioSesionCerrada = socio.cerrarSesion();
        socio = null;
        return socioSesionCerrada;
    }

}