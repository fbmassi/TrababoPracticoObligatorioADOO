package dtos;

import lombok.Data;

import java.util.Date;

@Data
public class MedicionDTO {
    private float peso;
    private float masaMuscular;
    private float porcentajeGrasaCorporal;
    private Date fecha;
    private IMedidorAdapter medidor;
}
