package model.trofeos;

import dtos.SocioDTO;
import model.ejercicios.DiaEntrenamiento;
import model.ejercicios.EjercicioARealizar;
import model.ejercicios.EjercicioDisponible;
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
        int ejerciciosRealizados = 0;
        int totalEjercicios = 0;
        List<DiaEntrenamiento> entrenamientos = socio.getObjetivoActual().getRutina().getEntrenamientos();
        for (DiaEntrenamiento diaEntrenamiento : entrenamientos) {
            List<EjercicioARealizar> ejerciciosARealizar = diaEntrenamiento.getEjercicios();
            for (EjercicioARealizar ejercicioARealizar : ejerciciosARealizar) {
                totalEjercicios++;
                if (ejercicioARealizar.isCompletado()) {
                    ejerciciosRealizados++;
                }
            }
        }
        return ejerciciosRealizados == totalEjercicios;
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