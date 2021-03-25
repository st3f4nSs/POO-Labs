package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Problema1 {
}



class Catalog  implements Subject{
    public ArrayList<Course> courses;
    private static Catalog instance = new Catalog();
    public ArrayList<Observer> observers;

    private Catalog() {
        courses = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Catalog getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Catalog: \n" +  courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(String name){
        for(Course course : courses){
            if(name.equals(course.name)){
                return course;
            }
        }
        return null;
    }
    public Grade getGrade(String name){
        for(Grade grade : getCourse(name).grades){
            if(name.equals(grade.getCourse())){
                return grade;
            }
        }
        return null;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for(Observer observer : observers)
            if(grade.getStudent().isParent(observer))
                observer.update(new Notification("Nota: " + grade));
    }
}

class Course {
    public String name;
    public Teacher teacher;
    public ArrayList<Assistant> assistants;
    public ArrayList<Grade> grades;
    public Strategy strategy;

    private Course(CourseBuilder builder) {
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.assistants = builder.assistants;
        this.grades = builder.grades;
        this.strategy = builder.strategy;
    }

    @Override
    public String toString() {
        return "Course: " + name + '\'';

    }

    public Student getBestStudent() {
        return strategy.getBestStudent(grades);
    }

    public static class CourseBuilder {
        private String name;
        private Teacher teacher;
        private ArrayList<Assistant> assistants;
        private ArrayList<Grade> grades;
        private Strategy strategy;


        public CourseBuilder(String name) {
            assistants = new ArrayList<>();
            grades = new ArrayList<>();
            this.name = name;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder assistant(Assistant assistant) {
            assistants.add(assistant);
            return this;
        }

        public CourseBuilder grade(Grade grade) {
            this.grades.add(grade);
            Collections.sort(grades);
            return this;
        }

        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}