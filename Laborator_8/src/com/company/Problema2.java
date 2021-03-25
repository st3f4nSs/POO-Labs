package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Catalog extends TreeSet<Catalog.Student> {

    public Catalog(Comparator comparator) {
        super(comparator);
    }

    public Catalog() {
        super();
    }

    public void addStudent(String name, double media, int clazz) {
        super.add(new Student(name, media, clazz));

    }

    public Student getStudent(String name) {
        Iterator<Student> iterator = super.iterator();

        while (iterator.hasNext()) {
            Student i = iterator.next();
            if(name.equals(i.name))
                return i;
        }
        return null;
    }

    public void removeStudent(String name) {
        Iterator<Student> iterator = super.iterator();

        while (iterator.hasNext()) {
            Student i = iterator.next();
            if(name.equals(i.name)) {
                super.remove(i);
                break;
            }
        }
    }

    public Catalog byClass(int clazz) {
        Catalog obj = new Catalog(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).name.compareTo(((Student) o2).name);
            }
        });
        Iterator<Student> iterator = super.iterator();

        while (iterator.hasNext()) {
            Student i = iterator.next();
            if(i.clazz == clazz) {
                obj.add(i);
            }
        }
        return obj;
    }

    class Student implements Comparable {
        public String name;
        public double media;
        public int clazz;

        public Student() {
            this("", 0, 0);
        }
        public Student(String name, double media, int clazz) {
            this.name = name;
            this.media = media;
            this.clazz = clazz;
        }
        @Override
        public int compareTo(Object o) {
            Student obj = (Student) o;

            if(this.media > obj.media)
                return 1;
            else if(this.media < obj.media)
                return -1;
            else
                return name.compareTo(obj.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", media=" + media +
                    ", clazz=" + clazz +
                    '}';
        }
    }

}

class Task2 {

    public static void main(String args[]) {
        Catalog catalog = new Catalog();
        catalog.addStudent("Alexandru", 7, 324);
        catalog.addStudent("Ioana", 5, 321);
        catalog.addStudent("Maria", 10, 322);
        catalog.addStudent("Ionut", 6.2, 323);
        catalog.addStudent("Diana", 7, 322);

        Catalog catalog2 = new Catalog(new Comparator<Catalog.Student>() {
            @Override
            public int compare(Catalog.Student o1, Catalog.Student o2) {
                Catalog.Student s1 = (Catalog.Student) o1;
                Catalog.Student s2 = (Catalog.Student) o2;

                if(s1.media > s2.media)
                    return -1;
                else if(s1.media < s2.media)
                    return 1;
                else
                    return s1.name.compareTo(s2.name);
            }
        });
        catalog2.addAll(catalog);

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + catalog);
        System.out.println("Continutul colectiei: " + catalog2);

        Catalog.Student last = null;
        for (Catalog.Student o : catalog) {
            if (last == null) {
                last = o;
                continue;
            }
            int r = last.media != o.media ? new Double(last.media).compareTo(o.media) : last.name.compareTo(o.name);
            if (r != last.compareTo(o)) {
                System.err.println("Catalog.Student.compareTo a fost implementata gresit.");
            }
        }

        if (catalog.size() != 5) {
            System.err.println("Catalog.size() a fost implementata gresit.");
        }

        catalog.removeStudent("Ionut");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }
        catalog.removeStudent("");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.byClass(322).size() != 2) {
            System.err.println("Catalog.byClass() a fost implementata gresit.");
        }

        catalog.removeStudent("Maria");
        if (catalog.byClass(322).size() != 1) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.getStudent("Maria") != null) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }

        if ((catalog.getStudent("Alexandru") == null) || (catalog.getStudent("Alexandru").media != 7)) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }
    }

}