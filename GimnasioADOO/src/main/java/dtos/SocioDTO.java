package dtos;

import lombok.Data;
import model.objetivos.ObjetivoPrincipal;
import model.trofeos.Trofeo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
public class SocioDTO {
    private int edad;
    private String sexoBiologico;
    private float altura;
    private float peso;
    private float masaMuscular;
    private float porcentajeGrasaCorporal;
    private ObjetivoPrincipal objetivoActual;
    private List<HashMap<Date, HashMap<String, Float>>> progreso;
    private List<Trofeo> trofeos;
    private boolean sesionIniciada;

    public SocioDTO(int edad, String sexoBiologico, float altura, float peso, float masaMuscular,
                    float porcentajeGrasaCorporal, ObjetivoPrincipal objetivoActual,
                    List<HashMap<Date, HashMap<String, Float>>> progreso, List<Trofeo> trofeos,
                    boolean sesionIniciada) {
        this.edad = edad;
        this.sexoBiologico = sexoBiologico;
        this.altura = altura;
        this.peso = peso;
        this.masaMuscular = masaMuscular;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.objetivoActual = objetivoActual;
        this.progreso = progreso;
        this.trofeos = trofeos;
        this.sesionIniciada = sesionIniciada;
    }
}