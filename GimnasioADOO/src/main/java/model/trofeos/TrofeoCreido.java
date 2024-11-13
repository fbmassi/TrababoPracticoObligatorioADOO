package model.trofeos;

import interfaces.IObservable;
import model.socio.Socio;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TrofeoCreido extends Trofeo {
    private String nombre;
    private String descripcion;

    public TrofeoCreido(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public boolean verificarTrofeo(IObservable observable) {
        if (observable instanceof Socio) {
            Socio socio = (Socio) observable;
            List<HashMap<Date, HashMap<String, Float>>> progreso = socio.getProgreso();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -1);
            Date fechaLimite = calendar.getTime();
            int contadorMediciones = 0;
            for (int i = progreso.size() - 1; i >= 0; i--) {
                Date fechaMedicion = progreso.get(i).keySet().iterator().next();
                if (fechaMedicion.after(fechaLimite)) {
                    contadorMediciones++;
                } else {
                    break;
                }
            }
            return contadorMediciones == 3;
        } else {
            return false;
        }
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
            }
        }
    }
}