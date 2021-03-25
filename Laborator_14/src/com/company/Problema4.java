package com.company;

import java.io.*;

public class Problema4 {
    public static void main(String[] argv) {
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter output = new BufferedWriter( new FileWriter("C:\\Users\\Stefan\\Desktop\\problema4.txt"));

            while (true) {
                String line = input.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    output.close();
                    break;
                }
                output.write(line + "\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nu exista fisierul.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
