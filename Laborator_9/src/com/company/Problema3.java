package com.company;
import java.util.ArrayList;

public class Problema3 {
    public static void main(String args[]) {
        IntegerMatrix matrix = new IntegerMatrix();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        matrix.add(array);
        matrix.add(array);
        matrix.add(array);
        matrix.add(array);
        System.out.println(matrix);
        System.out.println();


        System.out.println(matrix.addition(matrix));

    }
}

abstract class AMatrix<T extends Number> extends ArrayList<ArrayList<T>> {
    public abstract AMatrix<T> addition(AMatrix<T> m1);

    public abstract T sum(T obj1, T obj2);
}

class IntegerMatrix extends AMatrix<Integer> {
    public IntegerMatrix() {

    }

    @Override
    public AMatrix<Integer> addition(AMatrix<Integer> m1) {
        IntegerMatrix result = new IntegerMatrix();

        for(int i = 0; i < this.size(); i++) {
            ArrayList<Integer> line = new ArrayList<>();
            for(int j = 0; j < this.get(i).size(); j++) {
                int val1, val2;

                val1 = this.get(i).get(j);
                val2 = m1.get(i).get(j);
                line.add(sum(val1, val2));
            }
            result.add(line);
        }
        return result;
    }

    @Override
    public Integer sum(Integer obj1, Integer obj2) {
        return obj1 + obj2;
    }

    public String toString() {
        String result = "";

        for(ArrayList<Integer> i : this) {
            for(Integer j : i) {
                result += j + " ";
            }
            result += "\n";
        }
        return result;
    }
}