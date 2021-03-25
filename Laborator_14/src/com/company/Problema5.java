package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Problema5 {

    public static void main(String args[]) {
        try {
            int words = 0;
            StreamTokenizer sTokenizer = new StreamTokenizer(new FileReader("C:\\Users\\Stefan\\Desktop\\test02.in"));
            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF)
                if (sTokenizer.ttype == StreamTokenizer.TT_WORD)
                    words++;
            System.out.println("Text contains " + words + " words.");
        } catch (FileNotFoundException e) {
            System.err.println("Nu exista fisierul.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
