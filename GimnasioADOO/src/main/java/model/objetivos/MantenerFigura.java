package model.objetivos;

import dtos.SocioDTO;
import lombok.Data;
import model.ejericios.Rutina;
import model.ejericios.DiaEntrenamiento;
import model.socio.Socio;

import java.util.List;

@Data
public class MantenerFigura extends ObjetivoPrincipal {
    private float rangoPesoIdeal;

    @Override
    public Rutina calcularRutina(Socio socio) {

        this.rangoPesoIdeal = calcularRangoPesoIdeal(socio.getPeso());

        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, 7, 60, 4, "mediaBaja");
        Rutina rutina = new Rutina(dias, 4);
        rutina.setCumplida(false);
        return rutina;
    }

    @Override
    public boolean evaluarCumplimiento(Socio socio) {
        float pesoActual = socio.getPeso();
        return pesoActual >= rangoPesoIdeal - 2 && pesoActual <= rangoPesoIdeal + 2;
    }

    private float calcularRangoPesoIdeal(float pesoInicial) {
        return pesoInicial;
    }

}
