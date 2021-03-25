package com.company;

import java.util.*;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Compare implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        String string1 = (String) o1;
        String string2 = (String) o2;
        return string2.compareTo(string1);
    }
}

class SListSet extends LinkedList<Object> implements SortedSet<Object> {

    private Comparator<Object> comp;

    public SListSet() {
        comp = null;
    }

    public SListSet(Comparator<Object> comp) {
        this.comp = comp;
    }

    public boolean add(Object o) {
        if(!this.contains(o)) {
            super.add(o);
            Collections.sort(this, comp);
            return true;
        }
        return false;
    }

    @Override
    public Comparator<Object> comparator() {
        return comp;
    }

    @Override
    public SortedSet subSet(Object fromElement, Object toElement) {
        SortedSet<Object> str = new TreeSet<>(comp);
        int index_start, index_end;

        index_start = this.indexOf(fromElement);
        index_end = this.indexOf(toElement);
        if(index_start >= 0 && index_end >= 0)
            for(int i = index_start; i <= index_end; i++)
                str.add(this.get(i));
        return str;
    }

    @Override
    public SortedSet headSet(Object toElement) {
        SortedSet<Object> str = new TreeSet<>(comp);
        int index_stop;

        index_stop = this.indexOf(toElement);
        if(index_stop >= 0)
            for(int i = 0; i <= index_stop; i++)
                str.add(this.get(i));
        return str;
    }

    @Override
    public SortedSet tailSet(Object fromElement) {
        SortedSet<Object> str = new TreeSet<>(comp);
        int index_start;

        index_start = this.indexOf(fromElement);
        if(index_start >= 0)
            for(int i = index_start; i < this.size(); i++)
                str.add(this.get(i));
        return str;
    }

    public Object first() {
        return super.getFirst();
    }

    public Object last() {
        return super.getLast();
    }
}



public class Problema3 {

    public static void main(String args[]) throws FileNotFoundException{
        SListSet list = new SListSet();
        Scanner scanner;

        scanner = new Scanner(new File("C://Users//Stefan//Desktop//Problema1.txt"));// DE MODIFICAT CALEA
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] arrOfStr = line.split("\\s+");
            for(String i : arrOfStr)
                list.add(i);
        }
        System.out.println(list);
        System.out.println(list.first() + " " + list.last());
        System.out.println(list.subSet("are", "game"));
        System.out.println(list.headSet("creier"));
        System.out.println(list.tailSet("file"));

        SListSet list2 = new SListSet(new Compare());

        for(Object i : list)
            list2.add(i);
        System.out.println(list2);
    }
}
