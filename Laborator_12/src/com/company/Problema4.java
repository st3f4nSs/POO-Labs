package com.company;

public class Problema4 {
    public static void main(String args[]) {
        Pensionar p1 = new Pensionar(20, 10);
        Pensionar p2 = new Pensionar(30, 20);
        Pensionar p3 = new Pensionar(40, 30);
        Pensionar p4 = new Pensionar(33, 20);

        System.out.println(p1.getPensie());
        System.out.println(p2.getPensie());
        System.out.println(p3.getPensie());
        System.out.println(p4.getPensie());
    }

}

interface Strategy {
    public double calcul(int aniVechime, double salariu);
}

class TwentyStrategy implements Strategy {
    @Override
    public double calcul(int aniVechime, double salariu) {
        return (double)aniVechime / 20 * salariu;
    }
}

class ThirtyStrategy implements  Strategy {
    @Override
    public double calcul(int aniVechime, double salariu) {
        return (double) aniVechime / 30 * salariu;
    }
}

class FourtyStrategy implements  Strategy {
    @Override
    public double calcul(int aniVechime, double salariu) {
        return (double) aniVechime / 40 * salariu;
    }
}



class Pensionar {
    public int aniVechime;
    public double salariu;
    private Strategy strategy;

    public Pensionar(int aniVechime, double salariu) {
        this.aniVechime = aniVechime;
        this.salariu = salariu;
        if(aniVechime >= 0 && aniVechime < 30)
            strategy = new TwentyStrategy();
        else if(aniVechime >= 30 && aniVechime < 40)
            strategy = new ThirtyStrategy();
        else
            strategy = new FourtyStrategy();
    }

    public Pensionar() {
        this.aniVechime = 0;
        this.salariu = 0;
        this.strategy = null;
    }

    public double getPensie() {
        return strategy.calcul(aniVechime, salariu);
    }
}
