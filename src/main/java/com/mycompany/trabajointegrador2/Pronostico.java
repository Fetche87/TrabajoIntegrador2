package com.mycompany.trabajointegrador2;

public class Pronostico {
    private Partido partido;
    private ResultadoEnum resultado;
    private int puntaje;
    
    
    
    
    public Pronostico(Partido partido, ResultadoEnum resultado){
        this.partido = partido;
        this.puntaje = 0;
        this.resultado = resultado;
    }

    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    

    public int calcularPuntajePronostico(){
        
        ResultadoEnum resultadoReal = this.partido.decidirResultado();
        if (resultadoReal == this.resultado){
            return 1;
        } else {
            return 0;
        }
        
    }
    
    }
