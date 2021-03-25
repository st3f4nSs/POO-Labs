package com.company;

class Punct {
    private int x, y;

    public Punct() {
        x = y = 0;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    void setX(int value) {
        x = value;
    }

    void setY(int value) {
        y = value;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distance(int x2, int y2) {
        return Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y));
    }

    public double distance(Punct p) {
        return Math.sqrt((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y));
    }
}

class Test1 {
    public static void main(String args[]) {
        Punct p1 = new Punct();
        Punct p2 = new Punct();

        p1.setX(1);
        p1.setY(2);
        p2.setX(-1);
        p2.setY(3);
        System.out.println("Distanta dintre " + p1 + " si " + p2 + " este: " + p1.distance(p2));
    }
}