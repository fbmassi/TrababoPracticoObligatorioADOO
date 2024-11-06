package dtos;

import lombok.Data;

@Data
public class TrofeoDTO {
    private String nombre;
    private String descripcion;
    private Boolean otorgado;
    private FirebaseNotification notificador;
    }
}