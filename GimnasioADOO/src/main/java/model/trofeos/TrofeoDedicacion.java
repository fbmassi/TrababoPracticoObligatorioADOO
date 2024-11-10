package model.trofeos;

import dtos.SocioDTO;
import model.socio.Socio;

public class TrofeoDedicacion extends Trofeo {
    private String nombre;
    private String descripcion;
    private boolean otorgado;

    public TrofeoDedicacion(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public boolean verificarTrofeo(Socio socio) {
        return socio.getObjetivoActual().evaluarCumplimiento(socio);
    }

    @Override
    public void otorgarTrofeo(Socio socio) {
        socio.getTrofeos().add(this);
        otorgado = true;
    }

    @Override
    public void serNotifocadoPor(Socio observable) {
        if (verificarTrofeo(observable)) {
            otorgarTrofeo(observable);
        }
    }
}
