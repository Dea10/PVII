package com.dea.languageDet;

public class Main {
    public static void main(String[] args){

        //String entrada = "En un lugar de la Mancha de cuyo nombre no quiero acordarme";
        String entrada = "necreonoteitninnevrutsetnheinnodtohmeoeobesnmrxiubratslelriaerniavsair";
        String message;

        for(int i=3; i<10; i++){
            Transponedora t = new Transponedora(entrada, i);
            message = t.crack();

            Detector d = new Detector();
            d.detectarIdioma(message);
        }
    }
}
