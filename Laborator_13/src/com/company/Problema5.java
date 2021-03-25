package com.company;

import java.util.Collection;

public class Problema5 {

    public static void main(String args[]) {
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
    }
}

interface Strategy {
    Student getBestStudent(Collection<Grade> grades);
}

class BestPartialScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 0d;
        Student best_choice = null;

        for(Grade grade : grades)
            if(grade.getPartialScore() > max) {
                max = grade.getPartialScore();
                best_choice = grade.getStudent();
            }

        return best_choice;
    }
}

class BestExamScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 0d;
        Student best_choice = null;

        for(Grade grade : grades)
            if(grade.getExamScore() > max) {
                max = grade.getExamScore();
                best_choice = grade.getStudent();
            }

        return best_choice;

    }
}

class BestTotalScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 0d;
        Student best_choice = null;

        for(Grade grade : grades)
            if(grade.getTotal() > max) {
                max = grade.getTotal();
                best_choice = grade.getStudent();
            }

        return best_choice;
    }
}
