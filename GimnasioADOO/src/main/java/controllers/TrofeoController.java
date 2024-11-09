package controllers;

import dtos.SocioDTO;
import dtos.TrofeoDTO;
import model.Trofeo;
import lombok.Data;

public class TrofeoController {

    private final Trofeo trofeo;

    public TrofeoController(Trofeo trofeo) {
        this.trofeo = trofeo;
    }

    public Boolean verificarTrofeo(SocioDTO socio) {
        //
        return null;
    }

    public void otorgarTrofeo(SocioDTO socio) {
        //
    }
}
