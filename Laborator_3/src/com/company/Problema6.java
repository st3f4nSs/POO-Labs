package com.company;

class Graph {
    private int matrix[][];
    private final int Infinit = 9500;
    private int n;

    public Graph(int nodes) {
        n = nodes;
        matrix = new int[n + 1][n + 1];
    }

    public int getSize() { return n;}

    public void addArc(int v, int w, int cost) {
        if(v >= 1 && v <= n && w >= 1 && w <= n)
            matrix[v][w] = cost;
    }

    public boolean isArc(int v, int w) {
        if(v >= 1 && v <= n && w >= 1 && w <= n) {
            if(matrix[v][w] != 0 && matrix[v][w] != Infinit)
                return true;
            else
                return false;
        }
        return false;
    }

    public String toString() {
        int i, j;
        StringBuffer s = new StringBuffer();

        for(i = 1; i <= n; i++) {
            for(j = 1; j <= n; j++) {
                if(i == j) {
                    s.append("0").append(" ");
                } else if(isArc(i, j)) {
                    s.append(matrix[i][j]).append(" ");
                } else {
                    s.append("INF").append(" ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public int[][] floydWarshall() {
        int result[][];
        result = new int[n+1][n+1];
        int k, i, j;
        for(i = 1; i <= n; i++) {
            for(j = 1; j <= n; j++) {
                if(i == j) {
                    result[i][j] = 0;
                } else if(isArc(i, j)) {
                    result[i][j] = matrix[i][j];
                } else {
                    result[i][j] = Infinit;
                }
            }
        }
        for(k = 1; k <= n; k++) {
            for(i = 1; i <= n; i++) {
                for(j = 1; j <= n; j++) {
                    int dist;
                    dist = result[i][k] + result[k][j];
                    if(result[i][j] > dist) {
                        result[i][j] = dist;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addArc(1, 3, 2);
        g.addArc(1, 2, 3);
        g.addArc(2, 4, 6);
        g.addArc(2, 3, 2);
        System.out.println(g);
        System.out.println("Floyd-Warshall");
        int [][] my_matrix = g.floydWarshall();
        System.out.println("distanta minima dintre nodurile 1 si 4 este "+ my_matrix[1][4]); // rezultat - 9
    }

}