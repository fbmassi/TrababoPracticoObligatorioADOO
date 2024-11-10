package model.trofeos;

import dtos.SocioDTO;
import interfaces.IObservable;
import model.objetivos.ObjetivoPrincipal;
import model.socio.Socio;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TrofeoDedicacion extends Trofeo {
    private String nombre;
    private String descripcion;
    private boolean otorgado;

    public TrofeoDedicacion(String nombre, String descripcion) {
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
