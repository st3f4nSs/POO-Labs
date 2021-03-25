package com.company;

import java.util.Vector;
import java.util.HashMap;
import java.lang.String;

public class Problema6 {
    public static void main(String args[]) {
        Vector<Object> v = new Vector<>();
        HashMap<String, Integer> mp = new HashMap<>();

        v.add(7.5);
        v.add("String");
        v.add(5);
        v.add(true);
        v.add(7.544);

        for(int i = 0; i < v.size(); i++) {
            String key = v.get(i).getClass().getName();
            if(mp.containsKey(key)) {
                int value = mp.get(key);
                mp.put(key, value + 1);
            }
            else {
                mp.put(key, 1);
            }
        }
        for (String i : mp.keySet()) {
            if(mp.get(i) == 1)
                System.out.println("Clasa " + i + " apare o data.");
            else
                System.out.println("Clasa " + i + " apare de " + mp.get(i) + " ori.");
        }
    }
}