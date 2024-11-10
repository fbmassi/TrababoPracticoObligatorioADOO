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
    private boolean otorgado;

    public TrofeoConstancia(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public boolean verificarTrofeo(IObservable observable) {
        if (observable instanceof Socio) {
            Socio socio = (Socio) observable;
            if (!socio.getObjetivoActual().getRutina().getEntrenamientos().isEmpty()) {
                return !LocalDate.now().isBefore(socio.getObjetivoActual().getRutina().getEntrenamientos()
                        .get(socio.getObjetivoActual().getRutina().getEntrenamientos().size() - 1).getFecha())
                        && socio.getObjetivoActual().getRutina().verificarAsistencia();
            }
        }
        return false;
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