package com.mycompany.trabajointegrador2;

import java.util.ArrayList;

public class Ronda {
    private String numeroRonda;
    private ArrayList<Partido> partidos;

    public Ronda(String numeroRonda) {
        this.numeroRonda = numeroRonda;
        //this.partidos = partidos;
    }

    public String getNumeroRonda() {
        return numeroRonda;
    }

           
    public int calcularPuntajeRonda(){
        
        int puntajeRonda = 0;
        return puntajeRonda;
    }
    
    public void agergarPartido(Partido partido){
        this.partidos.add(partido);
    }
}
