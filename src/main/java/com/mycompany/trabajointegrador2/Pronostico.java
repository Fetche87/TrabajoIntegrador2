/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegrador2;

/**
 *
 * @author feder
 */
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
