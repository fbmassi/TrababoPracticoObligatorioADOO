package model;

import dtos.SocioDTO;
import lombok.Data;

import java.util.List;

@Data
public class BajarPeso extends ObjetivoPrincipal {
    private float pesoIdeal;

    @Override
    public Rutina calcularRutina(SocioDTO socio) {

        this.pesoIdeal = calcularPesoIdeal(socio);

        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, 7, 90, 3, "aerobico");
        Rutina rutina = new Rutina(dias, 4);
        rutina.setCumplida(false);
        return rutina;
    }

    @Override
    public boolean evaluarCumplimiento(SocioDTO socio) {
        return socio.getPeso() <= pesoIdeal;
    }

    private float calcularPesoIdeal(SocioDTO socio) {
        float altura = socio.getAltura() / 100;
        return socio.getSexoBiológico().equals("M") ? 22 * (altura * altura) : 21 * (altura * altura);
    }
}
