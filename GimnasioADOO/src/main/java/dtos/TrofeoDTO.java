package dtos;

@Data
public class TrofeoDTO {
    private String nombre;
    private String descripcion;
    private boolean otorgado;
    private FirebaseNotification notificador;
    }
}