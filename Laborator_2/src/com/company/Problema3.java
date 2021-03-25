package com.company;
import java.util.Collections;
import java.util.Vector;
import java.util.Random;

public class Problema3 {
    public int remove(Vector<Integer> v, int to_remove)
    {
        int cnt;
        boolean bec;

        cnt = 0;
        while(true) {
            bec = v.remove((Integer)to_remove);
            if(bec)
                cnt++;
            else
                break;
        }
        return cnt;
    }
    public void print(Vector<Integer> v) {
        System.out.print("Vectorul: " + v);
        System.out.println();
    }
    public static void main(String args[]) {
        Vector<Integer> vec = new Vector<Integer>(20);
        Problema3 obj = new Problema3();
        Random rnd = new Random();
        int to_remove;

        for(int i = 0; i < 20; i++) {
            int x = rnd.nextInt(10);
            vec.add(x);
        }
        obj.print(vec);         // metoda a clase care printeaza un vector.
        to_remove = 5;          // introducem valoarea pe care vrem sa o stergem.
        int rez = obj.remove(vec, to_remove); // functie care sterge elem = to_remove si returneaza nr de elem sterse
        System.out.println("Numarul de elemente egale cu " + to_remove + " este " + rez + ".");
        obj.print(vec);
        System.out.println();

        int poz_min, max;
        double avg;

        avg = 0;
        for(int i = 0; i < vec.size(); i++)
            avg += vec.get(i);
        avg = avg / vec.size();

        max = Collections.max(vec);
        poz_min = vec.indexOf(Collections.min(vec));
        System.out.println("Maximul este " + max + " .");
        System.out.println("Pozitia pe care se gaseste minimul este " + poz_min + " .");
        System.out.println("Media elementelor din vector este " + avg + " .");


    }
}
