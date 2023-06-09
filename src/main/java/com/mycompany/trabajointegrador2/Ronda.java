package com.mycompany.trabajointegrador2;

import java.util.ArrayList;

public class Ronda {
    private int numeroRonda;
    private ArrayList<Partido> partidos = new ArrayList<>();
    private int puntajeRonda;
    private ArrayList<Pronostico> pronosticos = new ArrayList<>();

    public Ronda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
        //this.partidos = partidos;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
     
    public int calcularPuntajeRonda(){
        int puntajeFinal = 0;
        for (Pronostico pronostico : this.pronosticos){
            puntajeFinal += pronostico.calcularPuntajePronostico();
        }
        return this.puntajeRonda = puntajeFinal;
    }
    
    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }
    
    public void agregarPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }

    public int getPuntajeRonda() {
        return puntajeRonda;
    }
    
    
            
    
}
