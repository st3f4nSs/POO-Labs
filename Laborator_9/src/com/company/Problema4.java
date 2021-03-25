package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Problema4 {
    public static void main(String args[]) {
        GenericListMetohds obj = new GenericListMetohds();
        ArrayList<String> myList = new ArrayList<>();
        ArrayList<String> no_duplicates = new ArrayList<>();

        myList.add("Ana");
        myList.add("Stefan");
        myList.add("Ana");
        myList.add("Mihai");
        myList.add("Mihai");

        System.out.println(myList);
        System.out.println(obj.max(myList));
        no_duplicates = obj.removeDuplicates(myList);
        System.out.println(no_duplicates);
        Collections.sort(no_duplicates);
        System.out.println(no_duplicates);
        System.out.println(obj.binarySearch(no_duplicates, "Stefan", 0, no_duplicates.size() - 1));
    }
}

interface GenericInterface {
    //Sterge duplicatele dintr-o lista si returneaza lista rezultata
    public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list);
    //Determina elementul maxim dintr-o lista
    public <E extends Comparable<E>> E max(ArrayList<E> list);
    //Cauta o valoare in lista sortata, folosind algoritmul de cautare binara si returneaza pozitia
    public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end);
}

class GenericListMetohds implements GenericInterface {

    @Override
    public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for(E value : list) {
            if(!result.contains(value))
                result.add(value);
        }
        return result;
    }

    @Override
    public <E extends Comparable<E>> E max(ArrayList<E> list) {
        E maximum;

        maximum = list.get(0);
        for(E value : list) {
            if(value.compareTo(maximum) > 0)
                maximum = value;
        }
        return maximum;
    }

    @Override
    public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (list.get(mid).equals(key))
            return mid;

        if (list.get(mid).compareTo(key) > 0)
            return binarySearch(list, key, start, mid - 1);
        if (list.get(mid).compareTo(key) < 0)
            return binarySearch(list, key, mid + 1, end);
        return -1;
    }
}
