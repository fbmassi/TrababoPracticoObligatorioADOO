package model.trofeos;

import dtos.SocioDTO;
import model.socio.Socio;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TrofeoCreido extends Trofeo {
    private String nombre;
    private String descripcion;
    private boolean otorgado;

    public TrofeoCreido(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public boolean verificarTrofeo(Socio socio) {

        List<HashMap<Date, HashMap<String, Float>>> progreso = socio.getProgreso();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1); // Obtener la fecha del mes anterior
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