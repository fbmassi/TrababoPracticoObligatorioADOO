package model.trofeos;

import dtos.SocioDTO;
import model.socio.Socio;

import java.util.List;

public class TrofeoConstancia extends Trofeo {
    private String nombre;
    private String descripcion;
    private boolean otorgado;

    public TrofeoConstancia(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public Boolean verificarTrofeo(SocioDTO socio) {
        return null;
    }

    public void otorgarTrofeo(SocioDTO socio) {
    }

    @Override
    public boolean verificarTrofeo(Socio socio) {
        socio.getObjetivoActual().getRutina().getEntrenamientos();
        return false;
    }

    @Override
    public void otorgarTrofeo(Socio socio) {

    }

    @Override
    public void serNotifocadoPor(Socio observable) {
        if (verificarTrofeo(observable)) {
            otorgarTrofeo(observable);
        }
    }
}