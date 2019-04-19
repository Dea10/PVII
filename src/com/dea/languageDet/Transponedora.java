package com.dea.languageDet;

import java.util.ArrayList;
import java.util.Arrays;

public class Transponedora {
    //atributos
    ArrayList<Character> arrayListCadena = new ArrayList<>();
    String cadena;
    String cadena2 = "";
    String cifrado = "";
    char[][] cadenaM;
    char[] cadenaU;
    int clave;
    int i, j, k = 0;

    String message;
    char[] message1D;
    char[][] messageAux;
    char[][] message2D;

    ArrayList<char[]> chunksArrayList;
    int chunkSize;
    int numberOfCunks;

    public Transponedora(String message, int key){
        this.message = message;
        //clean the string
        message = message.replace(" ", "");
        message1D = new char[message.length()];
        message2D = new char[key][key];
        //assign the string to a char[]

        //assign the array[] to a matrix[][]

        chunkSize = (int)Math.pow((double)key,2);
        numberOfCunks = (int)Math.ceil((double)message.length()/(double)chunkSize);
        messageAux = new char[3][chunkSize];
        chunksArrayList = new ArrayList<char[]>();
        int c=0, c2=0;

        for(i=0; i<numberOfCunks; i++) {
            c=0;
            for (j=0; j<chunkSize; j++) {
                if(c2 >= message.length()){
                    break;
                }
                messageAux[i][j] = message.substring(i * chunkSize).charAt(c);
                c++;
                c2++;
            }
        }

        for(int l=0; l<numberOfCunks; l++) {
            for (k = 0; k < chunkSize; k++) {
                System.out.print(messageAux[l][k]);
            }
            System.out.println();
        }
    }

    public void descifrar() {
        //asigno la cadena a un arreglo unidimensional
        for(i=0; i<cadena.length(); i++){
            cadenaU[i] = cadena.charAt(i);
        }

        //asigno el arreglo unidimensional a un arreglo multidimensional
        k = 0;
        try {
            for (i = 0; i < clave; i++) {
                for (j = 0; j < clave; j++) {
                    cadenaM[i][j] = cadenaU[k];
                    k++;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            descifrar(cadena, cadena.length()-(clave*clave));
        }

        //imprimo el arreglo multi
        System.out.println("::CadenaM::");
        for (i = 0; i < clave; i++) {
            for (j = 0; j < clave; j++) {
                System.out.print(cadenaM[i][j]);
            }
            System.out.println();
        }

        //imprimo una visualización transpuesta del arreglo multi
        System.out.println("\n::Transpuesta::");
        for (i = 0; i < clave; i++) {
            for (j = 0; j < clave; j++) {
                //asigno ordenadamente los caracteres a cifrado
                System.out.print(cadenaM[j][i]);
                cifrado += Character.toString(cadenaM[j][i]);
            }
            System.out.println();
        }
    }

    public void descifrar(String cadena, int corte) {
        //asigno la cadena a un arreglo unidimensional
        for(i=0; i<cadena.length(); i++){
            cadenaU[i] = cadena.substring(corte).charAt(i);
        }

        //asigno el arreglo unidimensional a un arreglo multidimensional
        k = 0;
        try {
            for (i = 0; i < clave; i++) {
                for (j = 0; j < clave; j++) {
                    cadenaM[i][j] = cadenaU[k];
                    k++;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            descifrar(cadena, cadena.length()-(clave*clave));
        }

        //imprimo el arreglo multi

        System.out.println("::CadenaM::");
        for (i = 0; i < clave; i++) {
            for (j = 0; j < clave; j++) {
                System.out.print(cadenaM[i][j]);
            }
            System.out.println();
        }

        //imprimo una visualización transpuesta del arreglo multi
        System.out.println("\n::Transpuesta::");
        for (i = 0; i < clave; i++) {
            for (j = 0; j < clave; j++) {
                //asigno ordenadamente los caracteres a cifrado
                System.out.print(cadenaM[j][i]);
                cifrado += Character.toString(cadenaM[j][i]);
            }
            System.out.println();
        }

        //imprimo entradas y cifrado
        /*
        System.out.println();
        System.out.println("Cadena: " + cadena);
        System.out.println("Cadena sin espacios: " + cadena2);
        System.out.println("Cifrado: " + cifrado);
        */
    }

    public void cifrar() {
        //asigno la cadena a un arreglo unidimensional
        for (i = 0; i < cadena2.length(); i++) {
            cadenaU[i] = cadena2.charAt(i);
        }

        //asigno el arreglo unidimensional a un arreglo multidimensional
        k = 0;
        for (i = 0; i < clave; i++) {
            for (j = 0; j < clave; j++) {
                cadenaM[i][j] = cadenaU[k];
                k++;
            }
        }

        //imprimo el arreglo multi
        System.out.println("::CadenaM::");
        for (i = 0; i < clave; i++) {
            for (j = 0; j < clave; j++) {
                System.out.print(cadenaM[i][j]);
            }
            System.out.println();
        }

        //imprimo una visualización transpuesta del arreglo multi
        System.out.println("\n::Transpuesta::");
        for (i = 0; i < clave; i++) {
            for (j = 0; j < clave; j++) {
                //asigno ordenadamente los caracteres a cifrado
                System.out.print(cadenaM[j][i]);
                cifrado += Character.toString(cadenaM[j][i]);
            }
            System.out.println();
        }

        //imprimo entradas y cifrado
        System.out.println();
        System.out.println("Cadena: " + cadena);
        System.out.println("Cadena sin espacios: " + cadena2);
        System.out.println("Cifrado: " + cifrado);
    }
}

