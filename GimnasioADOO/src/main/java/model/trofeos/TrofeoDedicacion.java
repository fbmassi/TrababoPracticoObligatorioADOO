package model.trofeos;

import interfaces.IObservable;
import model.socio.Socio;

public class TrofeoDedicacion extends Trofeo {
    private String nombre;
    private String descripcion;

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
