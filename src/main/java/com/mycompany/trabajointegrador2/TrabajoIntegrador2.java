package com.mycompany.trabajointegrador2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;


public class TrabajoIntegrador2 {

    public static void main(String[] args) {
        final String archivoResultados = "resultados.csv";
        final String separadorComa = ";";
        
    
        ArrayList <Partido> partidos = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int cantidadDeRondas = 0;
        String nombreParticipante= "";
        

        try{
            fileReader = new FileReader(archivoResultados);
            bufferedReader = new BufferedReader (fileReader);
            String linea;
            while((linea = bufferedReader.readLine()) !=null){
                
                String[] partidoComoArreglo = linea.split(separadorComa);
                    
                Equipo equipo1 = new Equipo(partidoComoArreglo[1]);
                Equipo equipo2 = new Equipo(partidoComoArreglo[4]);
                
                if (partidoComoArreglo.length != 5) {
                    System.out.println("Error de lectura: Faltan datos en el archivo resultados.csv");
                    return;
                }
                
                int numeroRonda = 0;
                int golesEquipo1 = 0;
                int golesEquipo2 = 0;
                
                try{
                    numeroRonda = Integer.valueOf(partidoComoArreglo[0]);
                    golesEquipo1 = Integer.valueOf(partidoComoArreglo[2]);
                    golesEquipo2 = Integer.valueOf(partidoComoArreglo[3]);
                    
                } catch (NumberFormatException e) {
                    System.out.println("El o los campos número de ronda o goles no son números enteros.");
                }
                if (numeroRonda > cantidadDeRondas){
                    cantidadDeRondas = numeroRonda;
                }
                
                partidos.add(new Partido(numeroRonda, equipo1, golesEquipo1, golesEquipo2, equipo2));
                
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
        
        
        
        /*for (Partido partido : partidos){
            for (Ronda ronda : numeroRonda){
                if (partido.getPersona() == participante.getNombre()){
                    participante.agregarPronostico(partido);
                }
            }
            
        }*/
        
        
        final String archivoPronosticos = "pronostico.csv";
        ArrayList <Pronostico> pronosticos = new ArrayList<>();
        ArrayList<Participante> participantes = new ArrayList<>();
        
        

        try {
            fileReader = new FileReader(archivoPronosticos);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                
                String[] pronosticoComoArreglo = linea.split(separadorComa);
                ResultadoEnum resultado = ResultadoEnum.EMPATE;
                Partido partido = BuscarPartidoPorNombreEquipos(partidos,pronosticoComoArreglo[1],pronosticoComoArreglo[5]);
                
                if (pronosticoComoArreglo.length != 6) {
                    System.out.println("Error de lectura: Faltan datos en el archivo resultados.csv");
                    return;
                }
                
                               
                if ("x".equals(pronosticoComoArreglo[2])) {
                    resultado = ResultadoEnum.GANA_EQUIPO_1;
                    
                } else if ("x".equals(pronosticoComoArreglo[4]) ) {
                    resultado = ResultadoEnum.GANA_EQUIPO_2;
                }
                
                pronosticos.add(new Pronostico(partido, resultado, pronosticoComoArreglo[0])); 
                
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
        int numeroLinea = 0;
        
        try {
            fileReader = new FileReader(archivoPronosticos);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                
                String[] pronosticoComoArreglo = linea.split(separadorComa);
                
                if (pronosticoComoArreglo[0] == null ? nombreParticipante != null : !pronosticoComoArreglo[0].equals(nombreParticipante)) {
                        nombreParticipante = pronosticoComoArreglo[0];
                        participantes.add(new Participante(nombreParticipante));
                    }
                               
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
        
        for (Pronostico pronostico : pronosticos){
            for (Participante participante : participantes){
                if (pronostico.getPersona() == null ? participante.getNombre() == null : pronostico.getPersona().equals(participante.getNombre())){
                    participante.agregarPronostico(pronostico);
                }
            }
            
        }
        
        
        
        /*
        Partido[] partidosRonda = new Partido[cantidadDePartidosPorRonda];
        //System.out.println(cantidadDeRondas);
        //System.out.println(cantidadDePartidosPorRonda);
        for (int i = 0; i <= cantidadDeRondas; i++){
            int  = 0;    
            
            for (Partido partido : partidos){
                    if (i + 1 == Integer.valueOf(partido.getNumeroRonda().getNumeroRonda())){
                    partidosRonda[posicion] = partido;
                    posicion += 1;
                }
                    
            }
            
        }*/
        
        /*        
        int puntajeFinalPersona = 0;
        for (Pronostico pronostico : pronosticos){
            puntajeFinalPersona += pronostico.calcularPuntajePronostico();
            
        }*/
        
        //System.out.println("El resultado final es de :" + puntajeFinalPersona);
        for (Participante participante : participantes){
            participante.calcularAciertos();
            participante.calcularPuntaje();
            System.out.println("Participante: " + participante.getNombre() + " - Puntaje: " + participante.getPuntaje() + " - Aciertos: " + participante.getCantidadAciertos());
        }
        
        
    }

    

        
    public static Partido BuscarPartidoPorNombreEquipos(ArrayList<Partido> partidos, String nombreEquipo1, String nombreEquipo2){
        Partido partidoEncontrado = partidos.stream().filter(partido ->partido.getEquipo1().getNombre().equals(nombreEquipo1) && partido.getEquipo2().getNombre().equals(nombreEquipo2)).findAny().orElse(null);
                return partidoEncontrado;
    }
    
    
}