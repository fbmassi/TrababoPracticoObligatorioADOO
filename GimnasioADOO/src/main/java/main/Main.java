package main;

import controllers.EjercicioController;
import interfaces.IMedidorAdapter;
import interfaces.IObserver;
import lombok.Data;
import model.ejercicios.DiaEntrenamiento;
import model.ejercicios.EjercicioARealizar;
import model.ejercicios.GrupoMuscular;
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

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Instanciamos Medidor y Objetivos
        IMedidorAdapter medidor = new Medidor();
        ObjetivoPrincipal bajarPeso = new BajarPeso();
        ObjetivoPrincipal tonificarCuerpo = new TonificarCuerpo();
        ObjetivoPrincipal mantenerFigura = new MantenerFigura();

        // Instanciar trofeos y agregar observadores
        Trofeo trofeoCreido = new TrofeoCreido("Trofeo al creido: Constante y al punto", "Has realizado al menos 3 mediciones en el último mes");
        Trofeo trofeoDedicacion = new TrofeoDedicacion("Trofeo a la Dedicación: Objetivo cumplido", "Has cumplido tu objetivo principal");
        Trofeo trofeoConstancia = new TrofeoConstancia("Trofeo a la constancia: Indomable", "Has completado todas las sesiones de tu rutina");
        List<IObserver> observers = List.of(trofeoCreido, trofeoDedicacion, trofeoConstancia);

        //Creamos al primer socio
        Socio ana = new Socio();
        ana.setUsername("Ana");
        ana.setClave("contraseña");
        ana.setEdad(25);
        ana.setSexoBiológico("F");
        ana.setAltura(165f);
        ana.setMedidor(medidor);
        ana.setObservadores(observers);

        // Instanciamos el controlador y se lo asignamos a Ana
        SocioController socioController = new SocioController(ana);



        // Iniciamos Sesion
        SocioDTO anaAutenticada = socioController.autenticarse("Ana", "contraseña");
        if (anaAutenticada != null) {
            System.out.println("Usuario autenticado correctamente");
            System.out.println(anaAutenticada);
        } else {
            System.out.println("Credenciales incorrectas");
        }

        // Fijamos el objetivo
        SocioDTO anaObjetivoFijado = socioController.setObjetivoPrincipal(bajarPeso);
        System.out.println(anaObjetivoFijado);

        // El socio se mide
        SocioDTO estadoActual = socioController.medirEstadoFisico();
        System.out.println("Estado actual después de la medición: " + estadoActual);

        // !IMPORTANTE! Acá se setea el peso sin el controller para que el objetivo se marque como cumplido.
        ana.setPeso(57);
        ana.notificarObservadores();

        // Se le otorga trofeo a la Dedicacion por haber cumplido su objetivo
        System.out.println("Trofeos de Ana: " + ana.getTrofeos());

        // Cerramos sesion
        socioController.cerrarSesion(anaAutenticada);
        System.out.println("Sesión cerrada");




        // Creamos otro socio
        Socio juan = new Socio();
        juan.setUsername("Juan");
        juan.setClave("12345");
        juan.setEdad(30);
        juan.setSexoBiológico("M");
        juan.setAltura(175f);
        juan.setMedidor(medidor);
        juan.setObservadores(observers);

        // Lo seteamos como el objeto del controlador.
        socioController.setSocio(juan);

        // Fijamos el objetivo
        SocioDTO juanObjetivoFijado = socioController.setObjetivoPrincipal(mantenerFigura);
        System.out.println(juanObjetivoFijado);

        // Mostramos la rutina en pantalla
        System.out.println(juanObjetivoFijado.getObjetivoActual().getRutina());

        // Lo hacemos medisrde tres veces a Juan para qeu se le otorgue le Trofeo al Creído.
        socioController.medirEstadoFisico();
        socioController.medirEstadoFisico();
        socioController.medirEstadoFisico();

        // Se le otorga trofeo al creído por haberse medido mas d etres veces en el mes
        System.out.println("Trofeos de Juan: " + juan.getTrofeos());

        // Cambiamos de Objetivo
        socioController.setObjetivoPrincipal(tonificarCuerpo);

        // Mostramos la rutina del en pantalla
        System.out.println(juan.getObjetivoActual().getRutina());

        // Mostramos como manipulamos los ejercicios
        Rutina rutinaJuan = juan.getObjetivoActual().getRutina();
        EjercicioController ejercicioController = new EjercicioController();
        ejercicioController.setRutina(rutinaJuan);

        List<DiaEntrenamiento> diaEntrenamientos = rutinaJuan.getEntrenamientos();

        // Iniciamos una rutina
        RutinaDTO rutinaJuanDTO = ejercicioController.iniciarRutina();
        System.out.println("Estado de Rutina de Juan: " + rutinaJuanDTO.getEstado() +"\n");

        for (DiaEntrenamiento diaEntrenamiento: diaEntrenamientos) {

            //Para cada día de entrenamiento, lo asignamos como el objeto del controladador.
            ejercicioController.setDiaEntrenamiento(diaEntrenamiento);

            //Iniciamos el Dia de Entrenamiento
            DiaEntrenamientoDTO diaDTO = ejercicioController.comenzarDiaEntrenamiento();
            System.out.println("Estado del día de entrenamiento - " + diaDTO.getFecha() + " - " + diaDTO.getEstado() + "\n");

            List<EjercicioARealizar> ejerciciosARealizarse = diaEntrenamiento.getEjercicios();

            for (EjercicioARealizar ejercicioARealizar: ejerciciosARealizarse) {

                // Seteamos el ejercicio a realizar como objeto del controlador
                ejercicioController.setEjercicioARealizar(ejercicioARealizar);

                //Imprimirmos por pantalla el estado del ejercicio antes de realizarlo
                System.out.println("Estado del entrenamiento antes de finalizado: " + ejercicioARealizar +"\n");

                EjercicioARealizarDTO progreso = ejercicioController.guardarProgreso(
                        ejercicioARealizar.getEjercicio().getSeries(),
                        ejercicioARealizar.getEjercicio().getRepeticiones(),
                        ejercicioARealizar.getEjercicio().getPesoAsignado()
                        );
                ejercicioController.marcarCompletado();

                //Imprimirmos por pantalla el estado del ejercicio luego de realizarlo
                System.out.println("Estado del entrenamiento luego de finalizado: " + ejercicioARealizar + "\n");
            }

            // Finalizamos el Dia de Entrenamiento
            diaDTO = ejercicioController.finalizarDiaEntrenamiento();
            System.out.println("Estado del día de entrenamiento - " + diaDTO.getFecha() + " - " + diaDTO.getEstado() + "\n");

        }

        rutinaJuanDTO = ejercicioController.finalizarRutina();
        System.out.println("Estado de Rutina de Juan: " + rutinaJuanDTO.getEstado() +"\n" );

        juan.notificarObservadores();

        // Se le otorga trofeo a la dedicación por haber completado todods los días de entrenamiento.
        System.out.println("Trofeos de Juan: " + juan.getTrofeos());

        //Seteamos otros objetivos para Juan y cambiamos la rutina asignada en el controller
        socioController.setObjetivoPrincipal(bajarPeso);
        ejercicioController.setRutina(juan.getObjetivoActual().getRutina());

        //Imprimirmos la rutina antes de reforzarla
        System.out.println(juan.getObjetivoActual().getRutina());

        //Reforzamos la rutina
        System.out.println(ejercicioController.reforzarRutina(3,3,3));

    }
}