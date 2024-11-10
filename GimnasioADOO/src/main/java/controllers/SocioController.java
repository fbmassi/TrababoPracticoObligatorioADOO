package controllers;

import dtos.SocioDTO;
import model.socio.Socio;
import model.objetivos.ObjetivoPrincipal;

public class SocioController {

    private final Socio socio;

    public SocioController(Socio socio) {
        this.socio = socio;
    }

    public SocioDTO setObjetivoPrincipal(ObjetivoPrincipal objetivo) {
        socio.setObjetivoPrincipal(objetivo);
        return socio.toDTO();
    }

    public SocioDTO medirEstadoFisico() {
        socio.medirEstadoFisico();
        return socio.toDTO();
    }

    public SocioDTO autenticarse(String username, String contraseña) {
        return socio.autenticarse(username, contraseña);
    }


    public SocioDTO cerrarSesion(SocioDTO socioDTO) {
        return socio.cerrarSesion();
    }

}