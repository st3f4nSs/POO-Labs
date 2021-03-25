package com.company;

import java.util.Arrays;

public class Problema8 {
    public static void main(String args[]) {
        double v[];
        int n;

        n = 10;                                                       // dimensiunea vectorului pe care o dorim
        v = new double[n];
        for(int i = 0; i < n; i++)
            v[i] = Math.random();                                     // asociem fiecarui element o valoare
        System.out.println("Vectorul este: " + Arrays.toString(v));   // inainte de sortare
        Arrays.sort(v);
        System.out.println("Vectorul este: " + Arrays.toString(v));   // dupa sortare

        double to_find, to_find2;
        int result;

        to_find = v[0];
        result = Arrays.binarySearch(v, to_find); // returneaza indexul din vector daca exista
        if(result >= 0)
            System.out.println("Elementul " + to_find + " apartine vectorului.");
        else
            System.out.println("Elementul " + to_find + " nu apartine vectorului.");

        to_find2 = v[0] - 0.00001;
        result = Arrays.binarySearch(v, to_find2); // returneaza indexul din vector daca exista
        if(result >= 0)
            System.out.println("Elementul " + to_find2 + " apartine vectorului.");
        else
            System.out.println("Elementul " + to_find2 + " nu apartine vectorului.");

    }
}
/*
Am creat un vector(dimensiunea se modifica modificand doar variabila n). Am parcurs vectorul si
am asociat fiecarui element al vectorului o val. L am printat inainte de sortare si dupa. Am afisat daca
apare sau nu un elem in vector.
 */