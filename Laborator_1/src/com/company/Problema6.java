package com.company;

public class Problema6 {

    public boolean isPrim(int x) {
        int div;

        if(x == 0 || x == 1)
            return false;
        if(x == 2)
            return true;
        if(x % 2 == 0)
            return false;
        for(div = 3; div <= Math.sqrt(x); div = div + 2) {
            if(x % div == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Problema6 obj = new Problema6();

        for(int i = 0; i < 20; i++) {
            if(obj.isPrim(i) == true)
                System.out.println("Numarul " + i + " este prim.");
        }
    }
}
