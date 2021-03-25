package com.company;

import java.util.Vector;

public class Problema4 {

    public Vector<Integer> intersectie(Vector<Integer> v, Vector<Integer> w) {
        Vector<Integer> aux = new Vector<>();
        int i, elem;

        for(i = 0; i < v.size(); i++) {
            elem = v.get(i);
            if(w.contains(elem))
                aux.add(elem);
        }
        return aux;
    }

    public Vector<Integer> reuniune(Vector<Integer> v, Vector<Integer> w) {
        Vector<Integer> aux = new Vector<>();
        int i, elem;

        for(i = 0; i < v.size(); i++)
            aux.add(v.get(i));
        for(i = 0; i < v.size(); i++) {
            elem = w.get(i);
            if(!aux.contains(elem))
                aux.add(elem);
        }
        return aux;
    }
    public Vector<Integer> diferenta(Vector<Integer> v, Vector<Integer> w) {
        Vector<Integer> aux = new Vector<>();
        int i, elem;

        for(i = 0; i < v.size(); i++) {
            elem = v.get(i);
            if(!w.contains(elem))
                aux.add(elem);
        }
        return aux;
    }
    public static void main(String[] args) {
        Problema4 obj = new Problema4();
        Vector<Integer> v = new Vector<>();
        Vector<Integer> w = new Vector<>();
        v.add(1);
        v.add(3);
        v.add(5);
        v.add(7);
        v.add(4);
        v.add(9);
        v.add(12);
        v.add(24);

        w.add(1);
        w.add(2);
        w.add(3);
        w.add(4);
        w.add(5);
        w.add(6);
        w.add(7);
        w.add(8);

        Vector<Integer> aux = obj.intersectie(v,w);
        for(Integer i : aux)
            System.out.print(i + " ");
        System.out.println();
        aux = obj.reuniune(v,w);
        for(Integer i : aux)
            System.out.print(i + " ");
        System.out.println();
        aux = obj.diferenta(v,w);
        for(Integer i : aux)
            System.out.print(i + " ");
    }
}
