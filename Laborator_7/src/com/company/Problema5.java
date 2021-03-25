package com.company;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Cel mai probabil trebuie instalata libraria org.apache.commons.io.FileUtils;
Mie nu mi-a mers decat dupa ce am instalat-o.
 */

public class Problema5 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();
        HashMap<String, Long> hashmap = new HashMap<>();
        String fileName = "C://Users//Stefan//Desktop//Problema5"; // DE MODIFICAT CALEA
        // daca nu modificam calea o sa dea pe langa FileNotFound si NUllPointerExp.
        File file = new File(fileName);

        File files[] = file.listFiles();
        for (File i : files) {
            long fileSize;

            if (i.isDirectory())
                fileSize = FileUtils.sizeOfDirectory(i) / 1024;
            else
                fileSize = i.length() / 1024;
            String file_name = i.getName();
            hashmap.put(file_name, fileSize);
        }

        for (Map.Entry<String, Long> entry : hashmap.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            System.out.println(key + " => " + value + " KB");
        }

        System.out.println();
        System.out.print("Crescator dupa key:\n");

        TreeMap<String, Long> sorted = new TreeMap<>();
        sorted.putAll(hashmap);
        for (Map.Entry<String, Long> entry : sorted.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            System.out.println(key + " => " + value + " KB");
        }

        System.out.println();
        System.out.print("Crescator dupa value:\n");

        TreeMap<String, Long> sortedD = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                Long val1 = hashmap.get(s1);
                Long val2 = hashmap.get(s2);
                if (val1.compareTo(val2) >= 0)
                    return 1;
                else
                    return -1;
            }
        });
        sortedD.putAll(hashmap);
        for (Map.Entry<String, Long> entry : sortedD.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            System.out.println(key + " => " + value + " KB");
        }
        System.out.println();
    }
}
