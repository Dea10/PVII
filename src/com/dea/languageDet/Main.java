package com.dea.languageDet;

public class Main {
    public static void main(String[] args){

        //String entrada = "En un lugar de la Mancha de cuyo nombre no quiero acordarme";
        String entrada = "necreonoteitninnevrutsetnheinnodtohmeoeobesnmrxiubratslelriaerniavsair";
        String message;

        Transponedora t = new Transponedora(entrada, 5);
        message = t.crack();
    }
}
