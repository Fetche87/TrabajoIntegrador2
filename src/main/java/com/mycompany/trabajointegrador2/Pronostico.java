package com.mycompany.trabajointegrador2;

public class Pronostico {
    private Partido partido;
    private ResultadoEnum resultado;
    private int puntaje;
    private String persona;
    public static final int PUNTAJE_POR_ACIERTO = 1;
    
    
    
    
    
    public Pronostico(Partido partido, ResultadoEnum resultado, String persona){
        this.partido = partido;
        this.puntaje = 0;
        this.resultado = resultado;
        this.persona = persona;
    }

    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getPersona() {
        return persona;
    }
    
    public Partido getPartido(){
        return partido;
    }
    
    

    public int calcularPuntajePronostico(){
        
            ResultadoEnum resultadoReal = this.partido.decidirResultado();
            if (resultadoReal == this.resultado) {
                return PUNTAJE_POR_ACIERTO;
            } 
        
            return 0;
        
    }
    
    public int calcularAciertoPronostico(){
            ResultadoEnum resultadoReal = this.partido.decidirResultado();
            if (resultadoReal == this.resultado) {
                return 1;
            }
            return 0;
    }
    
    }
