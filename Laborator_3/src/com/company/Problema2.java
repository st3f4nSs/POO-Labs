package com.company;

class Produs {
    String nume;
    double pret;
    int cantitate;

    public Produs(String nume, double pret, int cantitate) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public Produs() {
        this("",0, 0);
    }

    public String toString() {
        return "Produs " + nume + " " + pret + " " + cantitate + ".";
    }

    public double getTotalProdus() {
        return pret * cantitate;
    }
}

class Magazin {
    String nume;
    Produs p1, p2, p3;

    public Magazin(String nume, Produs p1, Produs p2, Produs p3) {
        this.nume = nume;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public String toString() {
        return "Magazinul " + nume + ":\n"+ p1 + "\n" + p2 + "\n" + p3;
    }

    public double getTotalMagazin() {
        return p1.getTotalProdus() + p2.getTotalProdus() + p3.getTotalProdus();
    }

    public static void main(String[] args) {
        Magazin mg = new Magazin("Le Big",
                new Produs("Carne",2.5,4),
                new Produs("Lapte",2.3,10),
                new Produs("Oua",3,10));

        System.out.println(mg);
        System.out.println();
        System.out.println(mg.getTotalMagazin());
    }
}


