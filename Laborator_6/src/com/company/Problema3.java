package com.company;

import java.util.Collections;
import java.util.Vector;

interface Persoana extends Comparable {
    public double calculMedieGenerala();
    public String getNume();
    public void setNume(String nume);
    public void addMedie(double medie);
}

class Student implements Persoana {
    private String name;
    private Vector<Double> average;

    public Student() {
        this("Gol");
    }

    public Student(String name) {
        this.name = name;
        average = new Vector<>();
    }

    @Override
    public double calculMedieGenerala() {
        double suma;

        suma = 0;
        for(Double i : average) {
            suma += i;
        }
        return suma / average.size();
    }

    @Override
    public String getNume() {
        return name;
    }

    @Override
    public void setNume(String nume) {
        name = nume;
    }

    @Override
    public void addMedie(double medie) {
        average.add(medie);
    }

    @Override
    public int compareTo(Object o) {
        Student obj = (Student) o;

        if(!this.name.equals(obj.name))
            return this.name.compareTo(obj.name);
        else {
            if(this.calculMedieGenerala() > obj.calculMedieGenerala())
                return -1;
            if(this.calculMedieGenerala() < obj.calculMedieGenerala())
                return 1;
        }
        return 0;
    }
}

class Main3 {
    public static void main(String args[]) {
        Vector<Student> v = new Vector<>();
        Student st1 = new Student("Stefan");
        st1.addMedie(10);
        st1.addMedie(9);
        st1.addMedie(10);
        st1.addMedie(10);
        Student st2 = new Student("Stefan");
        st2.addMedie(7);
        st2.addMedie(8);
        st2.addMedie(9);
        st2.addMedie(4);
        Student st3 = new Student("George");
        st3.addMedie(1);
        st3.addMedie(2);
        st3.addMedie(3);
        st3.addMedie(4);

        v.add(st1);
        v.add(st2);
        v.add(st3);

        Collections.sort(v);
        for(Student i : v)
            System.out.println(i.getNume() + " " + i.calculMedieGenerala());


    }
}