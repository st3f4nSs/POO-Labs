package com.company;
import java.util.*;

public class Problema2 {
    public int nr_words_1( String snt, String sir) {
        int cnt;

        cnt = 0;
        String words[] = snt.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(sir.equals(words[i]))
                cnt++;
        }
        return cnt;
        /*
        - impartim textul(propozitia in cuvinte);
        - comparam fiecare cuvant cu sirul cautat;
        - daca cele 2 cv sunt egale incrementam nr de aparitii.
         */
    }

    public int nr_words_2(String snt, String sir) {
        String delim = new String(" ,.!?:-\n");
        StringTokenizer st = new StringTokenizer(snt, delim);
        int cnt;

        cnt = 0;
        while (st.hasMoreTokens()) {
            if(sir.equals(st.nextToken()))
                cnt++;
        }
        return cnt;
        /*
        - impartim texul in cuvinte in functie de sirul de delimitatori;
        - cat timp mai avem token- uri comparam sirul dat un cv;
        - daca cele 2 cv sunt egale incrementam nr de aparitii.
         */
    }

    public static void main(String args[]) {
        Problema2 obj = new Problema2();
        int rez;
        rez = obj.nr_words_1("unu doi unu trei unu", "unu");
        System.out.println(rez);
        System.out.println();
        rez = obj.nr_words_2("Mihai merge des la munte.", "Mihai");
        System.out.println(rez);
    }
}
