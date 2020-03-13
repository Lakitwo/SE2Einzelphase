package com.example.matrikelalternator;

class CalcAlternate {


    String calcAlternate(String m) {

        int mnr = Integer.parseInt(m);
        int quersumme = 0;
        int checkIfEven = mnr % 2;
        boolean add = true;


        while (mnr > 0) {
            if (!add) {
                quersumme -= mnr % 10;
            } else {
                quersumme += mnr % 10;
            }
            add = !add;
            mnr /= 10;
        }
        mnr = quersumme;


        if (checkIfEven == 0) {
            return ("Die Matrikelnummer ist GERADE.\n" + "Die Alternierende Quersumme beträgt: " + mnr);
        } else {
            return ("Die Matrikelnummer ist UNGERADE.\n" + "Die Alternierende Quersumme beträgt: " + mnr);
        }

    }
}