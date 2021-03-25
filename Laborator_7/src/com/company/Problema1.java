package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Comparare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}


public class Problema1 {
    public static TreeSet<String> printWords(String file_path) throws FileNotFoundException {
        Scanner scanner;
        TreeSet<String> treeSet = new TreeSet<>();

        scanner = new Scanner(new File(file_path));
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] arrOfStr = line.split("\\s+");
            for(String i : arrOfStr)
                treeSet.add(i);
        }
        return treeSet;
    }

    public static TreeSet<String> printWordsComparator(TreeSet<String> treeSet) {
        TreeSet<String> treeDescent = new TreeSet<>(new Comparare());

        for(String i : treeSet)
            treeDescent.add(i);
        return treeDescent;
    }

    public static void main(String args[]) throws FileNotFoundException {
        TreeSet<String> treeSet = new TreeSet<>();
        TreeSet<String> treeSetD = new TreeSet<>();


        treeSet = printWords("C://Users//Stefan//Desktop//Problema1.txt");
        System.out.print("Elementele in ordine crescatoare: ");
        for(String i : treeSet)
            System.out.print(i + " ");
        treeSetD = printWordsComparator(treeSet);
        System.out.println();
        System.out.print("Elementele in ordine descrescatoare: ");
        for(String i : treeSetD)
            System.out.print(i + " ");


    }
}
