package com.company;

public class Problema3 {
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
                    .assistant((Assistant) assistant).grade(new Grade("POO", (Student) studentA, 4d, 5d))
                    .grade(new Grade("POO", (Student) studentB, 3d, 3d))/*.strategy(new BestExamScore())*/.build();
        }
}

class Grade implements Comparable<Grade> {
    private Double partialScore, examScore;
    private Student student;
    private String course;

    public Grade(String course, Student student) {
        partialScore = 0.0;
        examScore = 0.0;
        this.course = course;
        this.student = student;
    }

    public Grade(String course, Student student,Double partialScore, Double examScore ) {
        this.partialScore = partialScore;
        this.examScore = examScore;
        this.course = course;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Double getPartialScore() {
        return partialScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public String getCourse() {
        return course;
    }

    public void setPartialScore(Double score) {
        partialScore = score;
    }
    public void setExamScore(Double score) {
        examScore = score;
    }
    public Double getTotal() {
        return partialScore + examScore;
    }

    @Override
    public int compareTo(Grade o) {
        if(this.getTotal() > o.getTotal())
            return 1;
        else if(this.getTotal() < o.getTotal())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "partialScore=" + partialScore +
                ", examScore=" + examScore +
                ", student=" + student +
                ", course='" + course + '\'' +
                '}';
    }
}

