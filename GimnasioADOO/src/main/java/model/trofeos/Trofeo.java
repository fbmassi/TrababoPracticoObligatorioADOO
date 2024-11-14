package model.trofeos;

import interfaces.IObservable;
import interfaces.IObserver;
import lombok.Data;
import model.socio.Socio;
import utils.FirebaseNotification;

@Data
public abstract class Trofeo implements IObserver {
    private String nombre;
    private String descripcion;
    private FirebaseNotification notificador;

    public Trofeo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.notificador = new FirebaseNotification();
    }

    public abstract void otorgarTrofeo(Socio socio);

    public abstract boolean verificarTrofeo(IObservable observable);

}