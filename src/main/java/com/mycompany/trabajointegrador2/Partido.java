package com.mycompany.trabajointegrador2;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int numeroRonda;
    
    public Partido(int numeroRonda, Equipo equipo1, int golesEquipo1, int golesEquipo2, Equipo equipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.numeroRonda = numeroRonda;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getNumeroRonda() {
        return numeroRonda;
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
