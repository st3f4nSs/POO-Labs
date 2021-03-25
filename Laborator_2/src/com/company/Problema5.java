package com.company;

import java.lang.String;

public class Problema5 {
    public String cenzurare(String word) {
        char str[] = word.toCharArray();
        int n;

        n = str.length;
        for(int i = 0; i < n; i++)
            if(i != 0 && i != n - 1)
                str[i] = '*';
        String result = new String(str);
        return result;
        /*
        - functia primeste un string pe care il converteste in sir de
        caractere si apoi modifica toate caracterele in afara
        de prima si ultima litera in stelute.
         */
    }

    public String modificare(String cuvinte[], String text) {
        StringBuffer str = new StringBuffer();
        String words[] = text.split(" ");
        int i, j, bec, exista;

        exista = 0;
        for(i = 0; i < words.length; i++) {
            bec = 0;
            for(j = 0; j < cuvinte.length; j++)
                if(words[i].equals(cuvinte[j])) {
                    bec = 1;
                    exista = 1;
                    break;
                }
            if(bec == 1) {
                str.append(cenzurare(words[i]));
                str.append(" ");
            }
            else {
                str.append(words[i]);
                str.append(" ");
            }
        }
        if(exista == 1) {
            System.out.println("Text suspect.");
            return str.toString();
        }
        else {
            System.out.println("Nimic suspect.");
            return "";
        }
        /*
        - impart textul in cuvinte;
        - verific pt fiecare cv din text daca apare in sirul de cuvinte(cuvinte[]);
        - construiesc un StringBuffer in care adaug fie cuv cenzurat + spatiu, fie doar spatiu;
        - in momentul in care gasesc macar un cv din cuvinte prezent in text(words dupa split)
        exista = 1 ( pentru a afisa mesaul: "Text suspect", "Nimic suspect");
         */
    }
    public static void main(String args[]) {
        String text = "Un terorist avea o bomba";
        String cuvinte[] = new String[2];
        cuvinte[0] = "terorist";
        cuvinte[1] = "bomba";
        Problema5 prb5 = new Problema5();
        String rezultat;
        rezultat = prb5.modificare(cuvinte, text);
        System.out.println(rezultat);
    }
}
