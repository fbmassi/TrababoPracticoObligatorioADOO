package model.objetivos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.ejercicios.DiaEntrenamiento;
import model.ejercicios.Rutina;
import model.socio.Socio;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TonificarCuerpo extends ObjetivoPrincipal {
    private float nivelMasaMuscularIdeal;
    private float porcentajeGrasaIdeal;

    @Override
    public Rutina calcularRutina(Socio socio) {

        this.nivelMasaMuscularIdeal = obtenerMasaMuscularIdeal(socio);
        this.porcentajeGrasaIdeal = obtenerPorcentajeGrasaIdeal(socio);

        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, 7, 150, 4, "muscular");
        Rutina rutina = new Rutina(dias, 4);
        rutina.setCumplida(false);
        return rutina;
    }

    @Override
    public boolean evaluarCumplimiento(Socio socio) {
        return socio.getMasaMuscular() >= nivelMasaMuscularIdeal &&
                socio.getPorcentajeGrasaCorporal() <= porcentajeGrasaIdeal;
    }

    private float obtenerMasaMuscularIdeal(Socio socio) {
        return socio.getSexoBiológico().equals("M") ? 30 : 25;
    }

    private float obtenerPorcentajeGrasaIdeal(Socio socio) {
        return socio.getSexoBiológico().equals("M") ? 15 : 20;
    }

}
