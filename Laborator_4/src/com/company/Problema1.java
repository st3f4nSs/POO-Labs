package com.company;

class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram() {
    }

    public Paralelogram(int l1, int l2, double u1, double u2) {
        if(l1 > l2) {
            super.latura1 = l2;
            super.latura3 = l2;
            super.latura2 = l1;
            super.latura4 = l1;
        } else {
            super.latura1 = l1;
            super.latura3 = l1;
            super.latura2 = l2;
            super.latura4 = l2;
        }

        if(u1 < u2) {
            super.unghi1 = u1;
            super.unghi2 = u2;
            super.unghi3 = u1;
            super.unghi4 = u2;
        } else {
            super.unghi1 = u2;
            super.unghi2 = u1;
            super.unghi3 = u2;
            super.unghi4 = u1;
        }
    }

    public double area() { return latura1 * latura4 * Math.sin(Math.toRadians(unghi1)); }
}

class Dreptunghi extends Paralelogram {
    public Dreptunghi() {
    }

    public Dreptunghi(int l1, int l2) {
        super(l1, l2, 90, 90);
    }

    public double area() {
        return latura1 * latura2;
    }
}

class Romb extends Paralelogram {
    public double d1, d2;

    public Romb() {
        d1 = 0;
        d2 = 0;
    }

    public Romb(int l1, double u1, double u2, double d1, double d2) {
        super(l1, l1, u1, u2);
        this.d1 = d1;
        this.d2 = d2;
    }

    public double area() {
        return (d1 * d2) / 2;
    }
}

class Patrat extends Dreptunghi {
    public Patrat() {
    }

    public Patrat(int l) { super(l, l); }

    public double area() { return latura1 * latura1; }
}

class Verif1 {
    public static void main(String args[]) {
        Patrulater ptr = new Patrulater(5, 7, 10, 11, 60, 120, 90, 90);
        System.out.println("Patrulater: ");
        System.out.println("Perimetru: " + ptr.perimetru());
        System.out.println(ptr.latura1 + " " + ptr.latura2 + " " + ptr.latura3 + " " + ptr.latura4);
        System.out.println(ptr.unghi1 + " " + ptr.unghi2 + " " + ptr.unghi3 + " " + ptr.unghi4);
        System.out.println();

        Paralelogram paral = new Paralelogram(4, 8, 60, 120);
        System.out.println("Paralelogram: ");
        System.out.println("Perimetru: " + paral.perimetru());
        System.out.println("Aria: " + paral.area());
        System.out.println(paral.latura1 + " " + paral.latura2 + " " + paral.latura3 + " " + paral.latura4);
        System.out.println(paral.unghi1 + " " + paral.unghi2 + " " + paral.unghi3 + " " + paral.unghi4);
        System.out.println();
        /*
        - test runtime polymorphism;
        Paralelogram paral = new Dreptunghi(4, 8);
        System.out.println("Paralelogram: ");
        System.out.println("Perimetru: " + paral.perimetru());
        System.out.println("Aria: " + paral.area());
        System.out.println(paral.latura1 + " " + paral.latura2 + " " + paral.latura3 + " " + paral.latura4);
        System.out.println(paral.unghi1 + " " + paral.unghi2 + " " + paral.unghi3 + " " + paral.unghi4);
        System.out.println();
         */

        Dreptunghi drept = new Dreptunghi(4, 8);
        System.out.println("Dreptunghi: ");
        System.out.println("Perimetru: " + drept.perimetru());
        System.out.println("Aria: " + drept.area());
        System.out.println(drept.latura1 + " " + drept.latura2 + " " + drept.latura3 + " " + drept.latura4);
        System.out.println(drept.unghi1 + " " + drept.unghi2 + " " + drept.unghi3 + " " + drept.unghi4);
        System.out.println();

        Romb rb = new Romb(4, 60, 120, 5, 6);
        System.out.println("Romb: ");
        System.out.println("Perimetru: " + rb.perimetru());
        System.out.println("Aria: " + rb.area());
        System.out.println(rb.latura1 + " " + rb.latura2 + " " + rb.latura3 + " " + rb.latura4);
        System.out.println(rb.unghi1 + " " + rb.unghi2 + " " + rb.unghi3 + " " + rb.unghi4);
        System.out.println(rb.d1 + " " + rb.d2);
        System.out.println();

        Patrat pt = new Patrat(4);
        System.out.println("Patrat: ");
        System.out.println("Perimetru: " + pt.perimetru());
        System.out.println("Aria: " + pt.area());
        System.out.println(pt.latura1 + " " + pt.latura2 + " " + pt.latura3 + " " + pt.latura4);
        System.out.println(pt.unghi1 + " " + pt.unghi2 + " " + pt.unghi3 + " " + pt.unghi4);
        System.out.println();
    }
}

