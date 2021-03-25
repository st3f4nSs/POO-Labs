package com.company;

import java.util.Vector;

class Table {
    public Vector<Vector<Object>> matrix;

    public Table(Object rows[][]) {
        int i, j;

        matrix = new Vector<Vector<Object>>(rows.length);
        for(i = 0; i < rows.length; i++) {
            Vector<Object> aux = new Vector<>();
            for(j = 0; j < rows[i].length; j++)
                aux.add(rows[i][j]);
            matrix.add(aux);
        }
    }

    class CsvPrinter {
        public Vector<Vector<Object>> csv_matrix;

        public CsvPrinter(String delim) {
            int i, j;

            csv_matrix = new Vector<Vector<Object>>(matrix.size());
            for(i = 0; i < matrix.size(); i++ ) {
                Vector<Object> aux = new Vector<>();
                for(j = 0; j < matrix.get(i).size(); j++) {
                    aux.add(matrix.get(i).get(j));
                    if(j != matrix.get(i).size() - 1)
                        aux.add(delim);
                }
                csv_matrix.add(aux);
            }
        }

        public CsvPrinter() {
            this(",");
        }

    }

    class AsciiPrinter {
        public Vector<Vector<Object>> ascii_matrix;

        public AsciiPrinter(int v[]) {
            int i, j;

            ascii_matrix = new Vector<Vector<Object>>(matrix.size());
            for(i = 0; i < matrix.size(); i++) {
                Vector<Object> aux = new Vector<>();
                for(j = 0; j < matrix.get(i).size(); j++) {
                    int diff;
                    String auxiliary = matrix.get(i).get(j).toString();
                    diff = v[j] - auxiliary.length();
                    for(int cnt = 0; cnt < diff; cnt++)
                        auxiliary += " ";
                    auxiliary += "|";
                    auxiliary += " ";
                    aux.add(auxiliary);
                }
                ascii_matrix.add(aux);
            }
        }
    }


    public void print(AsciiPrinter obj) {
        int i, j;

        for(i = 0; i < obj.ascii_matrix.size(); i++) {
            for(j = 0; j < obj.ascii_matrix.get(i).size(); j++)
                System.out.print(obj.ascii_matrix.get(i).get(j));
            System.out.println();
        }
    }


    public void print(CsvPrinter obj) {
        int i, j;

        for(i = 0; i < obj.csv_matrix.size(); i++) {
            for(j = 0; j < obj.csv_matrix.get(i).size(); j++)
                System.out.print(obj.csv_matrix.get(i).get(j));
            System.out.println();
        }
    }

}

class Task4 {

    public static void main(String[] args) {
        Object rows[][] = new Object[][] {
                {"#", "Materie", "An", "Semestru", "Credite"},
                {1, "Programarea calculatoarelor", 1, 1, 6},
                {2, "Structuri de date", 1, 2, 6},
                {3, "Programare Orientata pe Obiecte", 2, 1, 6},
        };
        Table t = new Table(rows);
        t.print(t.new CsvPrinter());
        System.out.println();
        t.print(t.new AsciiPrinter(new int[] {2, 32, 3, 9, 8}));
    }

}
