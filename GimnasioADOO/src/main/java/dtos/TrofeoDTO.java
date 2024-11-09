package dtos;

import lombok.Data;

@Data
public class TrofeoDTO {
    private String nombre;
    private String descripcion;
    private boolean otorgado;
    private FirebaseNotification notificador;
    private List<IObserver> observers;
    }
}