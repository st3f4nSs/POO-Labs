package com.company;

import java.util.Collections;
import java.util.Vector;

class Array {
    //Vectorul in care se vor retine elementele
    private Vector vector;

    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        vector = new Vector();
    }

    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        vector.add(x);
    }

    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }

    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return vector.size();
    }

    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return vector.remove(x);
    }

    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return (Integer) vector.remove(pos);
    }

    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{";
        for(int i = 0; i < vector.size(); i++) {
            result += get(i) + ", ";
        }
        result += "}";
        return result;
    }

    public void sort() {
        Collections.sort(vector);
    }
}

class SortedArray extends Array {
    public SortedArray() { super(); }

    /*
    Am inserat elementele in ordine sortata, NU am inserat
    si dupa am sortat.
     */
    public void addElement(Integer x) {
        int nr_elem;

        nr_elem = super.getSize();
        if(nr_elem == 0)
            super.addElement(x);
        else {
            if(x < super.get(0))
                super.addElement(x, 0);
            else
                if(x > super.get(nr_elem - 1))
                    super.addElement(x);
            else {
                    for (int i = 0; i < nr_elem; i++)
                        if(super.get(i) > x) {
                            super.addElement(x, i);
                            break;
                        }
                }
        }
    }

    public int get(int poz) { return super.get(poz); }
    public int getSize() { return super.getSize(); }
    public boolean remove(Integer x) { return super.remove(x); }
    public Integer remove(int  pos) { return (Integer) super.remove(pos); }
    public String toString() { return super.toString(); }
}

class MyStack {                                       // push, pop, isEmpty, getTop;
    private Array arr;

    public MyStack() { arr = new Array(); }
    public void push(Integer elem) { arr.addElement(elem); }       // adaugam un elem la sfarsitul vectorului;
    public boolean isEmpty() {                                     // verificam daca dim. vectorului e != 0;
        if(arr.getSize() == 0)
            return true;
        else
            return false;
    }
    public void pop() {                                            // eliminam elementul de la sfarsitul vetorului
        if(arr.getSize() > 0)
            arr.remove(arr.getSize() - 1);
    }
    public Integer get_top() {                                      // returnam elementul din varful stivei;
        return arr.get(arr.getSize() - 1);                          // verificam cu isEmpty intai.
    }
    public String toString() {
        int size;
        StringBuffer str = new StringBuffer();

        size = arr.getSize() - 1;
        for(int i = size; i >= 0; i--)
            str.append(arr.get(i)).append(" ");
        return str.toString();
    }
}

class Main2 {
    public static void main(String args[]) {
        SortedArray v = new SortedArray();
        v.addElement(5);
        v.addElement(1);
        v.addElement(2);
        v.addElement(10);
        v.addElement(0);
        v.addElement(99);
        v.addElement(7);
        System.out.println(v);
        v.remove((Integer) 5);
        System.out.println(v);
        v.remove(0);
        System.out.println(v);
        System.out.println("Elementul de pe pozitia 0 este: " + v.get(0));
        System.out.println("Elementul de pe ultima pozitie este: " + v.get(v.getSize() - 1));


        System.out.println("\n");
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack: " + stack);
        System.out.println("Stergem elementul " + stack.get_top());
        stack.pop();

        System.out.println("Stack: " + stack);
        System.out.println("Stergem elementul " + stack.get_top());
        stack.pop();

        System.out.println("Stack: " + stack);
        System.out.println("Stergem elementul " + stack.get_top());
        stack.pop();

        System.out.println("Stack: " + stack);
        if(stack.isEmpty())
            System.out.println("Stiva vida.");
        else
            System.out.println("Stiva nevida");

        System.out.println("Stergem elementul " + stack.get_top());
        stack.pop();
        System.out.println("Stack: " + stack);
        if(stack.isEmpty())
            System.out.println("Stiva vida.");
        else
            System.out.println("Stiva nevida");
    }
}