package com.company;

public class Problema5 {
    public int power(int base, int exp) {
        if(exp == 0)
            return 1;
        else
            return base * power(base, exp - 1);
    }

    public void print(int base, int exp) {
        Problema5 obj = new Problema5();

        System.out.println("Resultatul functiei power: " + obj.power(base, exp));
        System.out.println("Resultatul functiei din Math: " + (int)Math.pow(base, exp));
    }

    public static void main(String args[]) {
        Problema5 obj = new Problema5();
        obj.print(5, 2);
    }
}
