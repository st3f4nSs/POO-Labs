package com.company;

class Fractie {
    int numarator, numitor;

    public Fractie(int numarator, int numitor) {
        this.numarator = numarator;
        this.numitor = numitor;
    }

    public Fractie() {
        this(0, 1);
    }

    static int cmmdc(int a, int b) // folosita pentru a simplifica fractia;
    {
        while(a != b)
            if(a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    public Fractie suma(Fractie f1) {
        int comDiv;
        Fractie res = new Fractie();

        res.numitor = this.numitor * f1.numitor;
        res.numarator = this.numarator * f1.numitor + f1.numarator * this.numitor;
        comDiv = cmmdc(res.numitor, res.numarator);
        res.numitor = res.numitor / comDiv;
        res.numarator = res.numarator / comDiv;
        return res;
    }

    public String toString() {
        return this.numarator + " / " + this.numitor;
    }

    public boolean equals(Object obj) {
        Fractie copy, copy2;

        if(obj == null)
            return false;
        if (!(obj instanceof Fractie))
            return false;
        Fractie fr = (Fractie) obj;
        if(Math.abs(this.numarator / this.numitor - fr.numarator / fr.numitor) < 0.000001)
            return true;
        else
            return false;
    }

    public static void main(String args[]) {
        Fractie f1 = new Fractie(2, 6);
        Fractie f2 = new Fractie(1, 3);
        Fractie f3;

        f3 = f1.suma(f2);
        System.out.println("Fractia " + f3);
        if(f1.equals(f2)) {
            System.out.println("Fractiile sunt egale.");
        } else {
            System.out.println("Fractiile sunt diferite.");

        }

    }
}