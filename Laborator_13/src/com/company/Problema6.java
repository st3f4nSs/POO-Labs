package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Problema6 {
    public static void main(String[] args) {
        //testare exercitiu 2
        User studentA = UserFactory.createUser("Student", "A", "Popescu");
        User studentB = UserFactory.createUser("Student", "B", "Ionescu");
        User studentC = UserFactory.createUser("Student", "C", "Ionescu");

        User mother = UserFactory.createUser("Parent", "M_AC", "Ionescu");
        User father = UserFactory.createUser("Parent", "T_AC", "Ionescu");

        User teacher = UserFactory.createUser("Teacher", "Teacher", "Georgescu");
        User assistant = UserFactory.createUser("Assistant", "Assistant", "Popescu");

        //testare exercitiu 3+5
        Course course = new Course.CourseBuilder("POO").teacher((Teacher) teacher)
                .assistant((Assistant) assistant).grade(new Grade("POO", (Student) studentA, 4d,5d))
                .grade(new Grade("POO", (Student) studentB,3d,3d)).strategy(new BestExamScore()).build();

        System.out.println("Curs: "+ course);
        System.out.println("Best Student:" + course.getBestStudent());

        //testare exercitiu 1+3+5
        Catalog catalog = Catalog.getInstance();
        catalog.addCourse(course);

        //testare exercitiu 4
        ((Student) studentB).setMother((Parent) mother);
        ((Student) studentB).setFather((Parent) father);
        ((Student) studentC).setMother((Parent) mother);

        catalog.addObserver((Parent) mother);
        catalog.addObserver((Parent) father);
        catalog.notifyObservers(new Grade("POO", (Student)studentB,2.5d,3d));

        //testare exercitiu 6
        HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores=new HashMap<>();
        ArrayList<Pair<Student, String, Double>> ar1=new ArrayList<>();
        ar1.add(new Pair(studentA,"POO",3.6d));
        examScores.put((Teacher)teacher,ar1);

        HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores= new HashMap<>();
        ArrayList<Pair<Student, String, Double>> ar2=new ArrayList<>();
        ar2.add(new Pair(studentC,"POO",4.6d));
        partialScores.put((Assistant)assistant,ar2);

        Visitor v=new ScoreVisitor(examScores,partialScores);

        v.visit((Teacher)teacher);
        System.out.println("Actualizare teacher:" + catalog);

        v.visit((Assistant)assistant);
        System.out.println("Actualizare assistant:" + catalog);

    }
}

interface Element {
    void accept(Visitor visitor);
}
interface Visitor {
    void visit(Assistant assistant);
    void visit(Teacher teacher);
}

class Pair<K, V1, V2> {
    private K key;
    private V1 value1;
    private V2 value2;
    public Pair(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }
    public K getKey() {
        return key;
    }
    public V1 getValue1() {
        return value1;
    }
    public V2 getValue2() {
        return value2;
    }
}
class ScoreVisitor implements Visitor {
    private HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores;
    private HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores;
    public ScoreVisitor(HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores, HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores){
        this.examScores=examScores;
        this.partialScores=partialScores;
    }

    public void visit(Assistant assistant) {
        ArrayList<Pair<Student, String, Double>> partial = partialScores.get(assistant);
        Catalog catalog = Catalog.getInstance();

        for(Pair<Student, String, Double> pair : partial) {
            if(catalog.getCourse(pair.getValue1()).grades.size() != 0){
                catalog.getGrade(pair.getValue1()).setExamScore(pair.getValue2());
            } else {
                Grade grade = new Grade(pair.getValue1(), pair.getKey());
                grade.setExamScore(pair.getValue2());
                catalog.getCourse(pair.getValue1()).grades.add(grade);
            }
        }
    }

    public void visit(Teacher teacher) {
        ArrayList<Pair<Student, String, Double>> exam = examScores.get(teacher);
        Catalog catalog = Catalog.getInstance();

        for(Pair<Student, String, Double> pair : exam) {
            if(catalog.getCourse(pair.getValue1()).grades.size() != 0){
                catalog.getGrade(pair.getValue1()).setExamScore(pair.getValue2());
            } else {
                Grade grade = new Grade(pair.getValue1(), pair.getKey());
                grade.setExamScore(pair.getValue2());
                catalog.getCourse(pair.getValue1()).grades.add(grade);
            }
        }
    }
}
