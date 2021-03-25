package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Problema3 {

    public static void main(String args[]) throws IOException {

        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\Stefan\\Desktop\\test01.in"));
        String line = lineNumberReader.readLine();
        int cnt = 1;
        while(line != null) {
            if(cnt % 2 != 0)
                System.out.println(lineNumberReader.getLineNumber() + ") " + line);
            cnt++;
            line = lineNumberReader.readLine();

        }
    }
}
