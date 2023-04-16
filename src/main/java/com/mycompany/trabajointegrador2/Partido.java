/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegrador2;

/**
 *
 * @author feder
 */
public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    
    public Partido(Equipo equipo1, int golesEquipo1, int golesEquipo2, Equipo equipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    

    public int getGolesEquipo1() {
        return this.golesEquipo1;
    }

    public int getGolesEquipo2() {
        return this.golesEquipo2;
    }
    
    public ResultadoEnum decidirResultado () {
        ResultadoEnum resultado = ResultadoEnum.EMPATE;
        if (this.golesEquipo1 > this.golesEquipo2){
            resultado = ResultadoEnum.GANA_EQUIPO_1;
        } else if (this.golesEquipo1 < this.golesEquipo2){
            resultado = ResultadoEnum.GANA_EQUIPO_2;
        }
            
        return resultado;
    }
    
    }
