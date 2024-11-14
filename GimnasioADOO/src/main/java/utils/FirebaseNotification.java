package utils;

import model.socio.Socio;
import model.trofeos.Trofeo;

public class FirebaseNotification
{
    public void enviarNotificacion(Socio socio, Trofeo trofeo) {
        System.out.println("Se notifica al socio " + socio.getUsername() +
                " que ha obtenido el trofeo " + trofeo.getNombre() +
                ". Felicitaciones!");
    }
}
