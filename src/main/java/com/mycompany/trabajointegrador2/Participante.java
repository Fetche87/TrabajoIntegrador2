package com.mycompany.trabajointegrador2;

import java.util.ArrayList;

public class Participante {
    private String nombre;
    private int puntaje;
    private int cantidadAciertos;
    private ArrayList<Pronostico> pronosticos = new ArrayList<>();

    public Participante(String nombre){
        this.nombre = nombre;
        //this.pronosticos = pronosticos;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    
    public int getPuntaje() {
        return puntaje;
    }

    public int getCantidadAciertos() {
        return cantidadAciertos;
    }
    
    
    
    public int calcularPuntaje(){
        int puntajeFinal = 0;
        for (Pronostico pronostico : this.pronosticos){
            puntajeFinal += pronostico.calcularPuntajePronostico();
        }
        return this.puntaje = puntajeFinal;
    }
    
    public int calcularAciertos(){
        int aciertosFinal = 0;
        for (Pronostico pronostico : this.pronosticos){
            aciertosFinal += pronostico.calcularPuntajePronostico();
        }
        return this.cantidadAciertos = aciertosFinal;
    }
    
    public void agregarPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }
}
