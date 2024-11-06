package controllers;

import dtos.SocioDTO;
import model.Socio;

public class SocioController {

    private final Socio socio;

    public static SocioController getInstance() {
        if (socioControlador == null) {
            socioControlador = new socioControlador();
        }
        return socioControlador;
    }

    public Socio crearSocio(SocioDTO socioDTO) {
        return new Socio(SocioDTO);
    }

    public void SetObjetivoPrincipal(objetivo ObjetivoPrincipalDTO) {

    }

    public void verEstadoFisico() {

    }

    public void autenticarse(username String, password String){

    }

    public void cerrarsesion() {

    }
}