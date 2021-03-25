/*
class Ana {
    public void print(Ana p) {
        System.out.println("Ana 1");
    }
}
class Mihai extends Ana {
    public void print(Ana p) {
        System.out.println("Mihai 1");
    }
    public void print(Mihai l) {
        System.out.println("Mihai 2");
    }
}
class Dana extends Mihai {
    public void print(Ana p) {
        System.out.println("Dana 1");
    }
    public void print(Mihai l) {
        System.out.println("Dana 2");
    }
    public void print(Dana b) {
        System.out.println("Dana 3");
    }
}

class Test{
    public static void main (String [] args) {
        Mihai stud1 = new Dana();
        Ana stud2 = new Mihai();
        Ana stud3 = new Dana();
        Dana stud4 = new Dana();
        Mihai stud5 = new Mihai();

        System.out.println("Caz 1:");
        stud1.print(new Ana());
        stud1.print(new Mihai());
        stud1.print(new Dana());
        System.out.println();

        System.out.println("Caz 2:");
        stud2.print(new Ana());
        stud2.print(new Dana());
        System.out.println();

        System.out.println("Caz 3:");
        stud2.print(new Mihai());
        stud3.print(new Dana());
        System.out.println();

        System.out.println("Caz 4:");
        stud3.print(new Ana());
        stud3.print(new Mihai());
        System.out.println();

        System.out.println("Caz 5:");
        ((Dana)stud3).print(new Mihai());
        ((Dana)stud3).print(new Dana());
        System.out.println();

        System.out.println("Caz 6:");
        stud4.print(new Dana());
        stud4.print(new Ana());
        System.out.println();

        System.out.println("Caz 7:");
        stud4.print(new Mihai());
        stud5.print(new Dana());
        System.out.println();

        System.out.println("Caz 8:");
        stud5.print(new Mihai());
        stud5.print(new Ana());
    }
}
*/