package model.trofeos;

import dtos.SocioDTO;
import interfaces.IObservable;
import model.ejercicios.DiaEntrenamiento;
import model.ejercicios.EjercicioARealizar;
import model.ejercicios.EjercicioDisponible;
import model.ejercicios.Estado;
import model.socio.Socio;

import java.util.List;

public class TrofeoConstancia extends Trofeo {
    private String nombre;
    private String descripcion;
    private boolean otorgado;

    public TrofeoConstancia(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public void otorgarTrofeo(Socio socio) {
        socio.getTrofeos().add(this);
        otorgado = true;
    }

    @Override
    public void serNotifocadoPor(IObservable observable) {
        if (observable instanceof Socio) {
            Socio socio = (Socio) observable;
            otorgarTrofeo(socio);
        }
    }
}