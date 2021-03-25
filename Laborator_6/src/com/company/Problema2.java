package com.company;

public class Problema2 {
    public static void main(String args[]) {
        //Rectangle rtl = new Shape(); EROARE - clasa SHAPE este abstracta;
        Rectangle obj = new Square(1, "verde", true); // CORECT, runtime polymorfism
        //Square ptr = new Rectangle(4, 6); - EROARE
        System.out.println(obj);
        /*
        //Conversie 1
        Circle c1 = new Circle();
        Square sq = (Square) c1;  // EROARE
        /*
        //Conversie 2
        Rectangle r = new Rectangle(5.0, 5.0); EROARE
        Square sq = (Square) r;
        */
        //Conversie 3
        Square sq = new Square(7.0);
        Rectangle r = (Rectangle) sq;
        System.out.println(r);
    }
}
