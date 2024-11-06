package model;

import dtos.SocioDTO;
import dtos.TrofeoDTO;
import lombok.Data;

@Data
abstract public class Trofeo {
    private String nombre;
    private String descripcion;
    private boolean otorgado;
    private FirebaseNotification notificador;
    private List<IObserver> observers;

    public Boolean verificarTrofeo(SocioDTO socio) {
        //
        return null;
    }

    public void otorgarTrofeo(Socio socio) {
        //
    }

    public void enviarNotificacion(SocioDTO socio, TrofeoDTO trofeo) {

    }

    public void agregarObs(IObserver) {

    }

    public void eliminarObs(IObserver) {

    }

    public TrofeoDTO toDTO() {
        TrofeoDTO dto = new TrofeoDTO();
        dto.setNombre(this.nombre);
        dto.setDescripcion(this.descripcion);
        dto.setOtorgado(this.otorgado);
        dto.setNotificador(this.notificador);
        //dto.setObservers()
        return dto;
    }
}