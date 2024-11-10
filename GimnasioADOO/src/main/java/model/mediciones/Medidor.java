package model.mediciones;

import interfaces.IMedidorAdapter;
import model.socio.Socio;

import java.util.List;
import java.util.Random;

public class Medidor implements IMedidorAdapter {

    @Override
    public List<Float> medirEstadoFisico(Socio socio) {
        Random random = new Random();

        float peso, grasaCorporal, masaMuscular;

        if (socio.getSexoBiológico().equalsIgnoreCase("Mujer")) {
            peso = random.nextInt(90 - 65 + 1) + 65;
            grasaCorporal = random.nextInt(35 - 25 + 1) + 25;
            masaMuscular = random.nextInt(30 - 20 + 1) + 20;
        } else {
            peso = random.nextInt(110 - 85 + 1) + 85;
            grasaCorporal = random.nextInt(30 - 20 + 1) + 20;
            masaMuscular = random.nextInt(40 - 25 + 1) + 25;
        }

        return List.of(peso, grasaCorporal, masaMuscular);
    }
}
