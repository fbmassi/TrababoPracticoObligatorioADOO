package model;

import dtos.SocioDTO;
import lombok.Data;

import java.util.List;

@Data
public class MantenerFigura extends ObjetivoPrincipal {
    private float rangoPesoIdeal;

    @Override
    public Rutina calcularRutina(SocioDTO socio) {
        // Calcular rango de peso ideal con margen de N unidades alrededor del peso inicial
        this.rangoPesoIdeal = calcularRangoPesoIdeal(socio.getPeso());

        // Crear una lista de días de entrenamiento con ejercicios aeróbicos entre 2 y 4 y de media-baja exigencia muscular
        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, 7, 60, 4, "mediaBaja");
        Rutina rutina = new Rutina(dias, 4);
        rutina.setCumplida(false);
        return rutina;
    }

    @Override
    public boolean evaluarCumplimiento(SocioDTO socio) {
        // Evaluar cumplimiento si el peso actual está dentro del rango ideal (+- N unidades)
        float pesoActual = socio.getPeso();
        return pesoActual >= rangoPesoIdeal - 2 && pesoActual <= rangoPesoIdeal + 2;
    }

    private float calcularRangoPesoIdeal(float pesoInicial) {
        // Lógica para definir un rango de peso ideal ajustado en +-2 unidades (configurable)
        return pesoInicial;
    }
}
