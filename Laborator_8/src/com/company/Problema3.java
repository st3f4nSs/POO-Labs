package com.company;

import java.util.Iterator;

class LinkedList<T> implements Iterable<T> {
    Node<T> first;
    Node<T> last;

    //Insereaza un nod la inceputul listei
    public void addFirst(T data) {
        Node<T> nou = new Node<>(data);

        if(first == null) {
            first = last = nou;
        } else {
            nou.next = first;
            first = nou;
        }
    }

    //Insereaza un nod la sfarsitul listei
    public void add(T data) {
        Node<T> nou = new Node<>(data);

        if(first == null) {
            first = last = nou;
        } else {
            last.next = nou;
            last = nou;
        }
    }

    //Returneaza primul nod din lista
    public Node<T> getNode() {
        return first;
    }

    //Returneaza un obiect de tip ListIterator
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    private static class Node<K> {
        public K value;
        public Node<K> next;

        public Node(K value, Node<K> node) {
            this.value = value;
            this.next = node;
        }

        public Node(K value) {
            this(value, null);
        }
    }
    class ListIterator<T> implements Iterator<T> {
        Node<T> curent;

        public ListIterator(LinkedList<T> ts) {
            curent = ts.first;
        }

        @Override
        public boolean hasNext() {
            if(curent == null)
                return false;
            return true;
        }

        @Override
        public T next() {
            T value = curent.value;
            curent = curent.next;
            return value;
        }
    }
}

class Task3 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.add(22);
        list.add(25);
        list.add(30);

        int last = 0;
        System.out.println("Afisare 1");
        for (Integer i : list) {
            System.out.print(i + ", ");
            if (i < last) {
                System.err.println("LinkedList a fost implementata gresit.");
            }
            last = i;
        }
        System.out.println();

        System.out.println("Afisare 2");
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
    }
}

