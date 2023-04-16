package com.mycompany.trabajointegrador2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TrabajoIntegrador2 {

    public static void main(String[] args) {
        final String archivoResultados = "resultados.csv";
        final String separadorComa = ";";
        
    
        ArrayList <Partido> partidos = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try{
            fileReader = new FileReader(archivoResultados);
            bufferedReader = new BufferedReader (fileReader);
            String linea;
            while((linea = bufferedReader.readLine()) !=null){
                
                String[] partidoComoArreglo = linea.split(separadorComa);
                    
                Equipo equipo1 = new Equipo(partidoComoArreglo[1]);
                Equipo equipo2 = new Equipo(partidoComoArreglo[4]);
                partidos.add(new Partido(equipo1, Integer.valueOf(partidoComoArreglo[2]), Integer.valueOf(partidoComoArreglo[3]), equipo2));
                
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null){
                        bufferedReader.close();
                    }
            } catch (IOException e){
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            
        }
        
        final String archivoPronosticos = "pronostico.csv";
        
        

        ArrayList <Pronostico> pronosticos = new ArrayList<>();
        

        try {
            fileReader = new FileReader(archivoPronosticos);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                
                String[] pronosticoComoArreglo = linea.split(separadorComa);
                ResultadoEnum resultado = ResultadoEnum.EMPATE;
                Partido partido = BuscarPartidoPorNombreEquipos(partidos,pronosticoComoArreglo[1],pronosticoComoArreglo[5]);
               
                if ("x".equals(pronosticoComoArreglo[2])) {
                    resultado = ResultadoEnum.GANA_EQUIPO_1;
                    
                } else if ("x".equals(pronosticoComoArreglo[4]) ) {
                    resultado = ResultadoEnum.GANA_EQUIPO_2;
                }
                pronosticos.add(new Pronostico(partido , resultado)); 
                
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            
        }
        int puntajeFinalPersona = 0;
        for (Pronostico pronostico : pronosticos){
            puntajeFinalPersona += pronostico.calcularPuntajePronostico();
            
        }
        
        System.out.println("El resultado final es de :" + puntajeFinalPersona);
    }

        
    public static Partido BuscarPartidoPorNombreEquipos(ArrayList<Partido> partidos, String nombreEquipo1, String nombreEquipo2){
        Partido partidoEncontrado = partidos.stream().filter(partido ->partido.getEquipo1().getNombre().equals(nombreEquipo1) && partido.getEquipo2().getNombre().equals(nombreEquipo2)).findAny().orElse(null);
                return partidoEncontrado;
    }
}