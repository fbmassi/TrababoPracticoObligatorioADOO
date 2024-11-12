package main;

import interfaces.IMedidorAdapter;
import interfaces.IObserver;
import model.mediciones.Medidor;
import model.objetivos.BajarPeso;
import model.objetivos.MantenerFigura;
import model.objetivos.ObjetivoPrincipal; // Asegúrate de importar tu clase ObjetivoPrincipal
import model.objetivos.TonificarCuerpo;
import model.socio.Socio;
import controllers.SocioController;
import dtos.*;
import model.trofeos.Trofeo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IMedidorAdapter medidor = new Medidor(); // Reemplaza con tu implementación real

        ObjetivoPrincipal bajarPeso = new BajarPeso();
        ObjetivoPrincipal tonificarCuerpo = new TonificarCuerpo();
        ObjetivoPrincipal mantenerFigura = new MantenerFigura();

        Socio ana = new Socio();
        ana.setUsername("ana");
        ana.setClave("contraseña");
        ana.setEdad(25);
        ana.setSexoBiológico("F");
        ana.setAltura(1.65f);
        ana.setMedidor(medidor);

        SocioController socioController = new SocioController(ana);

        SocioDTO usuarioAutenticado = socioController.autenticarse("ana123", "contraseña");
        if (usuarioAutenticado != null) {
            System.out.println("Usuario autenticado correctamente");
        } else {
            System.out.println("Credenciales incorrectas");
        }

        SocioDTO estadoActual = socioController.medirEstadoFisico();
        System.out.println("Estado actual después de la medición: " + estadoActual);

        ana.setObjetivoActual(bajarPeso);

        socioController.cerrarSesion(usuarioAutenticado);
        System.out.println("Sesión cerrada");
    }
}