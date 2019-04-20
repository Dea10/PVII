package com.dea.languageDet;

public class Transponedora {

    String cifrado = "";
    int i, j, k = 0, aux=0, key=0;
    String message;
    char[] message1D;
    char[][] messageAux;
    char[][] message2D;
    int chunkSize;
    int numberOfChunks;

    public Transponedora(String message, int key){
        this.message = message;
        this.key = key;
        //clean the string
        message = message.replace(" ", "");
        message1D = new char[message.length()];
        message2D = new char[key][key];
        //assign the string to a char[]

        chunkSize = (int)Math.pow((double)key,2);
        numberOfChunks = (int)Math.ceil((double)message.length()/(double)chunkSize);
        messageAux = new char[numberOfChunks][chunkSize];
        int c=0, c2=0;

        for(i=0; i<numberOfChunks; i++) {
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

        /*for(i=0; i<numberOfChunks; i++) {
            for (j = 0; j < chunkSize; j++) {
                System.out.print(messageAux[i][j]);
            }
            System.out.println();
        }*/
    }

    public String crack(){
        for(i=0; i<numberOfChunks; i++){
            aux=0;
            for(j=0; j<key; j++){
                for(k=0; k<key; k++){
                    message2D[j][k] = messageAux[i][aux];
                    //System.out.print(message2D[j][k]);
                    aux++;
                }
                //System.out.println();
            }

            //print transposed message2D
            //System.out.println("\n\t\t::Matrices transpuestas::");
            for (int l = 0; l < key; l++) {
                for (int m = 0; m < key; m++) {
                    //asigno ordenadamente los caracteres a cifrado
                    //System.out.print(message2D[m][l]);
                    cifrado += Character.toString(message2D[m][l]);
                }
                //System.out.println();
            }
        }
        System.out.println("\nMessage: " + cifrado);
        return cifrado;
    }
}

