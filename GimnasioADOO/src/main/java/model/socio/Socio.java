package model.socio;

import dtos.SocioDTO;
import interfaces.IMedidorAdapter;
import interfaces.IObserver;
import lombok.Data;
import model.objetivos.ObjetivoPrincipal;
import model.trofeos.Trofeo;
import model.trofeos.TrofeoCreido;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
public class Socio {
    private int edad;
    private String sexoBiológico;
    private float altura;
    private float peso;
    private float masaMuscular;
    private float porcentajeGrasaCorporal;
    private ObjetivoPrincipal objetivoActual;
    private boolean sesionIniciada;
    private String username;
    private String clave;
    private IMedidorAdapter medidor;
    private List<HashMap<Date, HashMap<String, Float>>> progreso;
    private List<Trofeo> trofeos;
    private List<IObserver> observadores;

    // Establece un nuevo objetivo principal
    public SocioDTO setObjetivoPrincipal(ObjetivoPrincipal objetivo) {
        this.objetivoActual = objetivo;
        notificarObservadores();
        return toDTO();
    }

    // Mide el estado físico utilizando el adaptador de medición
    public SocioDTO medirEstadoFisico() {

        this.peso = medidor.medirEstadoFisico(this).get(0);
        this.porcentajeGrasaCorporal = medidor.medirEstadoFisico(this).get(1);
        this.masaMuscular = medidor.medirEstadoFisico(this).get(2);

        HashMap<String, Float> mediciones = new HashMap<>();
        mediciones.put("Peso", peso);
        mediciones.put("MasaMuscular", masaMuscular);
        mediciones.put("PorcentajeGrasa", porcentajeGrasaCorporal);

        progreso.add(new HashMap<>() {{
            put(new Date(), mediciones);
        }});

        notificarObservadores();

        return toDTO();
    }

    public SocioDTO autenticarse(String username, String contraseña) {
        if (username.equals(this.username) && contraseña.equals(clave)) {
            this.sesionIniciada = true;
            return this.toDTO();
        } else {
            return null;
        }
    }

    public SocioDTO cerrarSesion() {
        sesionIniciada = false;
        return toDTO();
    }

    public void agregarObservador(IObserver o) {
        observadores.add(o);
    }

    public void eliminarObservador(IObserver o) {
        observadores.remove(o);
    }

    private void notificarObservadores() {
        for (IObserver observador : observadores) {
            observador.serNotifocadoPor(this);
        }
    }

    public SocioDTO toDTO() {
        return new SocioDTO(edad, sexoBiológico, altura, peso, masaMuscular, porcentajeGrasaCorporal, objetivoActual, progreso, trofeos, sesionIniciada);
    }
}
