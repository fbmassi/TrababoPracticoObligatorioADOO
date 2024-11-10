package model.objetivos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.ejercicios.DiaEntrenamiento;
import model.ejercicios.Rutina;
import model.socio.Socio;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BajarPeso extends ObjetivoPrincipal {
    private float pesoIdeal;

    @Override
    public Rutina calcularRutina(Socio socio) {

        this.pesoIdeal = calcularPesoIdeal(socio);

        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, 7, 90, 3, "aerobico");
        Rutina rutina = new Rutina(dias, 4);
        rutina.setCumplida(false);
        return rutina;
    }

    @Override
    public boolean evaluarCumplimiento(Socio socio) {
        return socio.getPeso() <= pesoIdeal;
    }

    private float calcularPesoIdeal(Socio socio) {
        float altura = socio.getAltura() / 100;
        return socio.getSexoBiológico().equals("M") ? 22 * (altura * altura) : 21 * (altura * altura);
    }
}
