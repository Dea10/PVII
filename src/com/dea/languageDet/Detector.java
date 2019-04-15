package com.dea.languageDet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Detector {

    String cadena;
    boolean esp = true;
    ArrayList<String> ES_dic = new ArrayList<String>();

    public Detector(String cadena){
        this.cadena = cadena;
        cadena = cadena.toLowerCase();
    }

    //revisión con el diccionario

    public void leerDiccionario(){

        /* --- Lectura de archivo --- */

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("/Users/danielespinosa/Documents/LanguageDet/dic");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
                //System.out.println(linea);
                ES_dic.add(linea);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        /* --- Fin de lectura de archivo --- */
    }

    public void detectarIdioma(){
        //Leo la línea a evaluar y comparo elemento a elemento con el diccionario para saber cuántas coincidencias existen

        String[] palabras = cadena.split(" ");

        //Evaluar cada elemento con el diccionario
        int coin = 0;

        //System.out.println("Palabras: " + palabras.length);
        for(int i = 0 ; i<palabras.length; i++){
            for(int j = 0; j<ES_dic.size(); j++){
                if(palabras[i].equals(ES_dic.get(j))){
                    coin++; //coincidencias
                    break;
                }
            }
        }

        System.out.println("Coincidencias: " + coin);
        System.out.println("Porcentaje: " + (float)coin/(float)palabras.length);
        //si >= 50% coincide, entonces es Español
        System.out.println("Español: " + (((float)coin/(float)palabras.length >= 0.5) ? "True" : "False"));

    }

}
