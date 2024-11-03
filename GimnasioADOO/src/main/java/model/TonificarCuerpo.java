package model;

import dtos.SocioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TonificarCuerpo extends ObjetivoPrincipal {
    private float nivelMasaMuscularIdeal;
    private float porcentajeGrasaIdeal;

    @Override
    public Rutina calcularRutina(SocioDTO socio) {

        this.nivelMasaMuscularIdeal = obtenerMasaMuscularIdeal(socio);
        this.porcentajeGrasaIdeal = obtenerPorcentajeGrasaIdeal(socio);

        List<DiaEntrenamiento> dias = generarDiasDeEntrenamiento(socio, 7, 150, 4, "muscular");
        Rutina rutina = new Rutina(dias, 4);
        rutina.setCumplida(false);
        return rutina;
    }

    @Override
    public boolean evaluarCumplimiento(SocioDTO socio) {
        return socio.getMasaMuscular() >= nivelMasaMuscularIdeal &&
                socio.getPorcentajeGrasa() <= porcentajeGrasaIdeal;
    }

    private float obtenerMasaMuscularIdeal(SocioDTO socio) {
        return socio.getSexoBiológico().equals("M") ? 30 : 25;
    }

    private float obtenerPorcentajeGrasaIdeal(SocioDTO socio) {
        return socio.getSexoBiológico().equals("M") ? 15 : 20;
    }
}
