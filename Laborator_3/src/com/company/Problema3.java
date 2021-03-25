package com.company;
import java.lang.StringBuffer;
class MyArray {
    private int v[];
    private int size;

    public MyArray() {
        this(100);
    }

    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }

    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }

    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }

    public int getSize() {
        return size;
    }
}

class MyQueue {
    private MyArray arr;
    private final int Infinit = 9500;
    private int first;
    private int last;
    private int dim;

    public MyQueue() {
        arr = new MyArray();
        first = 0;
        last = 0;
        dim = 0;
    }

    public int getSize() {
        return dim;
    }

    public boolean isEmpty() {
        return dim == 0;
    }
    /*
    verific daca dimensiunea cozii este 0.
     */
    public void enqueue(int value) {
        if (dim != 0) {
            first++;
        }
        arr.set(first, value);
        dim++;
    }
    /*
    - initial ambii indici sunt pe pozitia 0, 0;
    - daca dimensiunea cozii e 0 adaug elem pe poz first si incrementez dimensiunea;
    - daca dimensiunea cozii e != 0 adaug elem pe poz first + 1 si incrementez dimensiunea;
     */

    public int dequeue() {
        int result = arr.get(last);
        last++;
        dim--;
        return result;
    }
    /*
    - micsorez coada, mutand indicele last cu o poz la dreapta;
    - scad dimensiunea;
     */
    public String toString() {
        int i;
        StringBuffer s = new StringBuffer();
        for(i = first; i >= last; i--)
            s.append(arr.get(i)).append(" ");
        return s.toString();
    }
}

class Test {
    public static void main(String args[]) {
        MyQueue queue = new MyQueue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(-1);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.enqueue(9);
        queue.enqueue(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(22);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println(queue);
    }
}