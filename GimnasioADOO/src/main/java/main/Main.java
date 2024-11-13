package main;

import controllers.EjercicioController;
import interfaces.IMedidorAdapter;
import interfaces.IObserver;
import lombok.Data;
import model.ejercicios.DiaEntrenamiento;
import model.ejercicios.EjercicioARealizar;
import model.ejercicios.Rutina;
import model.mediciones.Medidor;
import model.objetivos.BajarPeso;
import model.objetivos.MantenerFigura;
import model.objetivos.ObjetivoPrincipal; // Asegúrate de importar tu clase ObjetivoPrincipal
import model.objetivos.TonificarCuerpo;
import model.socio.Socio;
import controllers.SocioController;
import dtos.*;
import model.trofeos.Trofeo;
import model.trofeos.TrofeoConstancia;
import model.trofeos.TrofeoCreido;
import model.trofeos.TrofeoDedicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Instanciamos Medidor
        IMedidorAdapter medidor = new Medidor();

        //Instanciamos Objetivos
        ObjetivoPrincipal bajarPeso = new BajarPeso();
        ObjetivoPrincipal tonificarCuerpo = new TonificarCuerpo();
        ObjetivoPrincipal mantenerFigura = new MantenerFigura();

        // Instanciar trofeos
        Trofeo trofeoCreido = new TrofeoCreido("Trofeo al creido: Constante y al punto", "Has realizado al menos 3 mediciones en el último mes");
        Trofeo trofeoDedicacion = new TrofeoDedicacion("Trofeo a la Dedicación: Objetivo cumplido", "Has cumplido tu objetivo principal");
        Trofeo trofeoConstancia = new TrofeoConstancia("Trofeo a la constancia: Indomable", "Has completado todas las sesiones de tu rutina");
        List<IObserver> observers = new ArrayList<>();
        observers.add(trofeoConstancia);
        observers.add(trofeoDedicacion);
        observers.add(trofeoCreido);


        //Creamos al primer socio
        Socio ana = new Socio();
        ana.setUsername("Ana");
        ana.setClave("contraseña");
        ana.setEdad(25);
        ana.setSexoBiológico("F");
        ana.setAltura(165f);
        ana.setMedidor(medidor);
        ana.setObservadores(observers);

        //Instanciamos el controlador y se lo asignamos a Ana
        SocioController socioController = new SocioController(ana);

        //Iniciamos Sesion
        SocioDTO usuarioAutenticado = socioController.autenticarse("Ana", "contraseña");
        if (usuarioAutenticado != null) {
            System.out.println("Usuario autenticado correctamente");
        } else {
            System.out.println("Credenciales incorrectas");
        }

        //Fijamos el objetivo
        socioController.setObjetivoPrincipal(bajarPeso);

        //El socio se mideSocioDTO estadoActual = socioController.medirEstadoFisico();
        System.out.println("Estado actual después de la medición: " + estadoActual);

        ana.setPeso(57);
        ana.notificarObservadores();

        //Cerramos sesion
        socioController.cerrarSesion(usuarioAutenticado);
        System.out.println("Sesión cerrada");

        // Crear otro socio
        Socio juan = new Socio();
        juan.setUsername("Juan");
        juan.setClave("12345");
        juan.setEdad(30);
        juan.setSexoBiológico("M");
        juan.setAltura(175f);
        juan.setMedidor(medidor);
        juan.setObservadores(observers);

        socioController.setSocio(juan);

        socioController.setObjetivoPrincipal(mantenerFigura);

        socioController.medirEstadoFisico();
        socioController.medirEstadoFisico();
        socioController.medirEstadoFisico();

        socioController.setObjetivoPrincipal(tonificarCuerpo);

        Rutina rutinaJuan = juan.getObjetivoActual().getRutina();
        EjercicioController ejercicioController = new EjercicioController();
        ejercicioController.setRutina(rutinaJuan);

        List<DiaEntrenamiento> diaEntrenamientos = rutinaJuan.getEntrenamientos();

        for (DiaEntrenamiento diaEntrenamiento: diaEntrenamientos) {
            ejercicioController.setDiaEntrenamiento(diaEntrenamiento);
            List<EjercicioARealizar> ejercicioARealizars = diaEntrenamiento.getEjercicios();
            System.out.println(ejercicioController.comenzarDiaEntrenamiento());
            for (EjercicioARealizar ejercicioARealizar: ejercicioARealizars) {
                ejercicioController.setEjercicioARealizar(ejercicioARealizar);
                ejercicioController.marcarCompletado();
                //System.out.println(ejercicioARealizar);
            }
        }

        juan.notificarObservadores();

        // Verificar trofeos
        System.out.println("Trofeos de Ana: " + ana.getTrofeos());
        System.out.println("Trofeos de Juan: " + juan.getTrofeos());
    }
}