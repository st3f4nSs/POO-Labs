package com.company;

class Numar {
    private int x;

    public int suma(int a) {
        return x + a;
    }

    public int suma(int a, int b) {
        return this.suma(a) + b;
    }

    public int suma(int a, int b, int c) {
        return this.suma(a, b) + c;
    }

    public int suma(int a, int b, int c, int d) {
        return this.suma(a, b, c) + d;
    }
    public static void main(String args[]) {
        Numar nr = new Numar();
        nr.x = 3;
        System.out.println(nr.suma(1));
        System.out.println(nr.suma(1, 2));
        System.out.println(nr.suma(1, 2, 3));
        System.out.println(nr.suma(1, 2, 3, 4));
    }
}
