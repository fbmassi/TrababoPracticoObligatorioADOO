package model.trofeos;

import dtos.SocioDTO;
import interfaces.IObservable;
import model.ejercicios.*;
import model.socio.Socio;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TrofeoConstancia extends Trofeo {
    private String nombre;
    private String descripcion;

    public TrofeoConstancia(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public boolean verificarTrofeo(IObservable observable) {
        if (observable instanceof Socio) {
            Socio socio = (Socio) observable;
            if (!socio.getObjetivoActual().getRutina().getEntrenamientos().isEmpty()) {
                return socio.getObjetivoActual().getRutina().verificarCumplimiento();
            }
        }
        return false;
    }

    @Override
    public void otorgarTrofeo(Socio socio) {
        boolean existeTrofeo = socio.getTrofeos().stream()
                .anyMatch(trofeo -> trofeo.getNombre().equals(this.getNombre()));
        if (!existeTrofeo) {
            socio.getTrofeos().add(this);
        }
    }

    @Override
    public void serNotifocadoPor(IObservable observable) {
        if (observable instanceof Socio) {
            Socio socio = (Socio) observable;
            if (verificarTrofeo(observable)) {
                otorgarTrofeo(socio);
                getNotificador().enviarNotificacion(socio, this);
            }
        }
    }
}