package com.company;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class NumarNegativ extends Exception {
    public NumarNegativ() {
        super("Numarul introdus este negativ!");
    }
}

public class Problema3 {
    private Vector<Integer> v;

    public Problema3() {
        v = new Vector<>();
    }

    public void myRead() throws NumarNegativ {
        Scanner scan = new Scanner(System.in);
        int val;

        val = scan.nextInt();
        while(true) {
            if(val < 0)
                throw new NumarNegativ();
            v.add(val);
            val = scan.nextInt();
        }
    }

    public static void main(String args[]) {
        Problema3 obj = new Problema3();
        try{
            obj.myRead();
        } catch(NumarNegativ e) {
            System.out.println(e);
        }
        for(Integer i : obj.v)
            System.out.println(i + " ");
        System.out.println(Collections.max(obj.v));
    }
}
