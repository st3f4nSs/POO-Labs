package com.company;

public class Problema1 {

    public int indexOf(String text, String sir) {
        int cnt, poz;

        cnt = 0;
        poz = text.indexOf(sir, 0);;
        while(poz != -1) {
            cnt++;
            poz = text.indexOf(sir, poz + 1);
        }
        return cnt;
        /*
        - initializam poz cu prima pozitie a primei aparitii a lui
        sir in text;
        - cat timp mai exista aparitii ale lui sir in text;
        - incrementam numarul de aparitii si calculam noul poz.
         */
    }

    public int substring(String text, String sir) {
        int cnt, i;

        cnt = 0;
        for(i = 0; i <= text.length() - sir.length(); i++) {
            if(sir.equals(text.substring(i, i + sir.length())))
                cnt++;
        }
        return cnt;
        // am luat toate sirurile de lungimea lui sir, consecutine
        // si le am comparat cu sir. In cazul in care sunt egale
        // incrementam numarul de aparitii.
    }
    public static void main(String args[]) {
        String s1 = "si";
        String s2 = "sir1 si cu sir2 fac un sir3";;
        Problema1 p1 = new Problema1();

        System.out.println(p1.indexOf(s2, s1));
        System.out.println(p1.substring(s2, s1));
    }
}
