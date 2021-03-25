package com.company;

import java.util.Vector;

abstract class Vagon {
    private int pasageri;
    private int colete;

    public Vagon() {
        this(0, 0);
    }
    public Vagon(int pasageri, int colete) {
        this.pasageri = pasageri;
        this.colete = colete;
    }

    public int getPasageri() {
        return pasageri;
    }

    public void setPasageri(int pasageri) {
        this.pasageri = pasageri;
    }

    public int getColete() {
        return colete;
    }

    public void setColete(int colete) {
        this.colete = colete;
    }
    public abstract void open_door();
    public abstract void close_door();
    public abstract void block_window();
}

class CalatoriA extends Vagon {
    public CalatoriA() {
        super(40, 300);
    }

    @Override
    public void open_door() {
        System.out.println("Se deschid usile automat in vagonul de CalatoriA.");
    }
    @Override
    public void close_door() {
        System.out.println("Se inchid usile automat in vagonul de CalatoriA.");
    }

    @Override
    public void block_window() {
        System.out.println("Geamurile nu se blocheaza automat.");
    }
}

class CalatoriB extends Vagon {
    public CalatoriB() {
        super(50, 400);
    }

    @Override
    public void open_door() {
        System.out.println("Se deschid usile automat in vagonul de CalatoriB.");
    }

    @Override
    public void close_door() {
        System.out.println("Se inchid usile automat in vagonul de CalatoriB.");
    }

    @Override
    public void block_window() {
        System.out.println("Se blocheaza geamurile automat in vagonul de CalatoriB.");
    }
}

class Marfa extends Vagon {
    public Marfa() {
        super(0, 400);
    }

    @Override
    public void close_door() {
        System.out.println("Usile se inchid manual.");
    }

    @Override
    public void open_door() {
        System.out.println("Usile se deschid manual.");
    }

    @Override
    public void block_window() {
        System.out.print("");
    }
}

class Tren implements Comparable{
    public Vector<Vagon> vagoane;

    public Tren() {
        vagoane = new Vector<>();
    }

    public void addVagon(Vagon vag) {
        vagoane.add(vag);
    }

    public void removeVagon(Vagon vag) {
        if(vagoane.contains(vag))
            vagoane.remove(vag);
    }

    public void removeVagon(int index) {
        if(vagoane.size() > 0 && index >= 0 && index < vagoane.size())
            vagoane.remove(index);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        for(Vagon i : vagoane) {
            str.append(i.getClass().getName()).append("\n");
        }
        return str.toString();
    }

    private int getSum() {
        int sum;

        sum = 0;
        for (Vagon i : vagoane)
            sum += i.getColete();
        return sum;
    }

    @Override
    public int compareTo(Object o) {
        Tren t = (Tren) o;

        if(this.getSum() > t.getSum())
            return 1;
        else if(this.getSum() < t.getSum())
            return -1;
        else
            return 0;
    }
}

public class Problema5
{
    public static void main(String args[]) {
        Tren t = new Tren();
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriB());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriB());
        t.addVagon(new CalatoriB());
        t.addVagon(new Marfa());

        Tren t2 = new Tren();
        t2.addVagon(new CalatoriA());
        t2.addVagon(new CalatoriA());
        t2.addVagon(new CalatoriA());
        t2.addVagon(new CalatoriA());
        t2.addVagon(new CalatoriA());
        t2.addVagon(new CalatoriA());
        t2.addVagon(new CalatoriA());
        t2.addVagon(new Marfa());

        for(Vagon i : t.vagoane) {
            i.open_door();
            i.close_door();
            i.block_window();
            System.out.println("\n");
        }
        System.out.println(t);
        if(t.compareTo(t2) > 0)
            System.out.println("Trenul 1 poate sa transporte mai multe colete decat 2.");
        else if(t.compareTo(t2) < 0)
            System.out.println("Trenul 2 poate sa transporte mai multe colete decat 1.");
        else
            System.out.println("Ambele trenuri pot transporta aceeasi cantitate de colete.");
    }
}
