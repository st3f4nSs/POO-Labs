package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problema4 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner;
        TreeMap<String, LinkedList<Integer>> tree = new TreeMap<>();
        int line_number;

        line_number = 1;
        scanner = new Scanner(new File("C://Users//Stefan//Desktop//Problema1.txt")); // DE MODIFICAT CALEA
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] arrOfStr = line.split("\\s+");
            for(String i : arrOfStr) {
                if(!tree.containsKey(i)) {
                    tree.put(i, new LinkedList<>());
                    tree.get(i).add(line_number);
                } else {
                    LinkedList<Integer> aux = new LinkedList<>();
                    aux = tree.get(i);
                    if(!aux.contains(line_number))
                        aux.add(line_number);
                }
            }
            line_number++;
        }
        for(Map.Entry<String, LinkedList<Integer>> entry : tree.entrySet()) {
            String key = entry.getKey();
            LinkedList<Integer> value = entry.getValue();

            System.out.println(key + " => " + value);
        }
    }
}
