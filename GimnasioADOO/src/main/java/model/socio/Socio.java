package model.socio;

import dtos.SocioDTO;
import interfaces.IMedidorAdapter;
import interfaces.IObservable;
import interfaces.IObserver;
import lombok.Data;
import model.objetivos.ObjetivoPrincipal;
import model.trofeos.Trofeo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
public class Socio implements IObservable {
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
    private List<HashMap<Date, HashMap<String, Float>>> progreso = new ArrayList<>();
    private List<Trofeo> trofeos = new ArrayList<>();
    private List<IObserver> observadores = new ArrayList<>();

    public SocioDTO setObjetivoPrincipal(ObjetivoPrincipal objetivo) {
        this.objetivoActual = objetivo;
        objetivoActual.calcularRutina(this);
        setObjetivoActual(objetivo);
        return toDTO();
    }

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

    public void notificarObservadores() {
        for (IObserver observador : observadores) {
            observador.serNotifocadoPor(this);
        }
    }

    public SocioDTO toDTO() {
        return new SocioDTO(edad, sexoBiológico, altura, peso, masaMuscular,
                porcentajeGrasaCorporal, objetivoActual, progreso, trofeos, sesionIniciada);
    }

}
