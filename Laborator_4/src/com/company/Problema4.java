package com.company;

import java.util.Vector;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public void setAddress(String address) {
        this.address = address;
    }
    public String toString() {
        return "Nume: " + name + ", Address: " + address;
    }
}

class Student extends Person {
    private Vector<String> courses;
    private Vector<Integer> grades;

    public Student(String name, String address) {
        super(name, address);
        courses = new Vector<>();
        grades = new Vector<>();
    }

    public void addCourseGrade(String course, int grade) {
        courses.add(course);
        grades.add(grade);
    }

    public void printGrades() {
        System.out.print("Notele elevului " + super.getName() + " sunt: ");
        for(int i : grades)
            System.out.print(i + " ");
        System.out.println();
    }

    public double getAverageGrade() {
        int cnt;
        double avg;

        avg = 0;
        cnt = grades.size();
        for(int i : grades)
            avg += i;
        avg = avg / cnt;
        return avg;
    }
}

class Teacher extends Person {
    private Vector<String> courses;

    public Teacher(String name, String address) {
        super(name, address);
        courses = new Vector<>();
    }

    /*
    Verificam intai daca exista cursul. In cazul in care
    cursul exista deja returnam false, altfel il adaugam si
    returnam true;
     */
    public boolean addCourse(String course) {
        if(!courses.contains(course)) {
            courses.add(course);
            return true;
        }
        return false;
    }
    /*
    Verificam intai daca exista cursul. In cazul in care
    cursul exista deja returnam false, altfel il stergem si
    returnam true;
     */
    public boolean removeCourse(String course) {
        if(courses.contains(course)) {
            courses.remove(course);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        for(String i : courses)
            str.append(i).append(" ");
        return str.toString();
    }
}

class Test4 {
    public static void main(String args[]) {
        Person student, teacher, person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");
        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        ((Student) student).addCourseGrade("Programare", 10);
        ((Student) student).addCourseGrade("Algoritmica", 9);
        ((Student) student).addCourseGrade("Matematica", 8);
        assert (Math.abs(((Student) student).getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa " +
                "Student nu a fost implementat corect";
        ((Student) student).printGrades();
        //Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);
        System.out.println(person);
        System.out.println("Felicitari! Problema a fost rezolvata corect!");

         /*
        System.out.println(((Teacher) teacher).addCourse("Programare"));
        System.out.println(teacher);
        System.out.println(((Teacher) teacher).addCourse("Algoritmica"));
        System.out.println(teacher);
        System.out.println(((Teacher) teacher).addCourse("Matematica"));
        System.out.println(teacher);
        System.out.println(((Teacher) teacher).addCourse("Programare"));
        System.out.println(teacher);
        System.out.println(((Teacher) teacher).removeCourse("Programare"));
        System.out.println(teacher);
        System.out.println(((Teacher) teacher).addCourse("Programare"));
        System.out.println(teacher);
         */
    }
}