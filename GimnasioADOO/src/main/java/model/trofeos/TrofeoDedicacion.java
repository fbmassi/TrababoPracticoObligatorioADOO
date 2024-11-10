package model.trofeos;

import interfaces.IObservable;
import model.socio.Socio;

public class TrofeoDedicacion extends Trofeo {
    private String nombre;
    private String descripcion;
    private boolean otorgado;

    public TrofeoDedicacion(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public boolean verificarTrofeo(IObservable observable) {
        if (observable instanceof Socio) {
            Socio socio = (Socio) observable;
            return socio.getObjetivoActual().evaluarCumplimiento(socio);
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
            if (verificarTrofeo(observable)) {
                otorgarTrofeo(socio);
            }
        }
    }
}
