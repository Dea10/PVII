package com.dea.languageDet;

public class Transponedora {
    //atributos
    String cadena;
    String cadena2 = "";
    String cifrado = "";
    char[][] cadenaM;
    char[] cadenaU;
    int clave;
    int i, j, k = 0;

    //constructor
    public Transponedora(String cadena) {
        this.cadena = cadena;
        //clave = detectarClave(cadena);

        /*if(clave < 0){
            System.out.println("Error al detectar la clave!" +
                    "\nLongitud de la cadena introducida: " + cadena.length() );
        }
        */
        for (i = 3; i<=7; i++){
            cadenaM = new char[i][i];
            cadenaU = new char[cadena.length()];
            descifrar(cadena, i);
            System.out.println("Fin de iteración: "+ i +"\n\n\n\n");
        }
    }

    public Transponedora(String cadena, int clave) {
        this.cadena = cadena;
        this.clave = clave;
        cadena2 =cadena.replace(" ","");
        cadenaM = new char[clave][clave];
        cadenaU = new char[clave * clave];
    }

    //métodos de cifrado e impresión de resultados

    public int detectarClave(String s) {
        for(i=3; i<s.length(); i++){
            if (s.length()%i == 0){
                System.out.println("Clave detectada: " + i);
                return i;
            }
        }
        return -1;
    }

    public void descifrar(String s, int clave) {
        //asigno la cadena a un arreglo unidimensional
        for (i = 0; i < s.length(); i++) {
            try {
                cadenaU[i] = s.charAt(i);
            }catch (ArrayIndexOutOfBoundsException e){
                //System.out.println(e);
                descifrar(s.substring((clave * clave)-1), clave);
            }
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

