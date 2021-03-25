package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Problema2 {
        public static void main(String[] args) {
            User studentA = UserFactory.createUser("Student", "A", "Popescu");
            User studentB = UserFactory.createUser("Student", "B", "Ionescu");
            User studentC = UserFactory.createUser("Student", "C", "Ionescu");

            User mother = UserFactory.createUser("Parent", "M_AC", "Ionescu");
            User father = UserFactory.createUser("Parent", "T_AC", "Ionescu");

            User teacher = UserFactory.createUser("Teacher", "Teacher", "Georgescu");
            User assistant = UserFactory.createUser("Assistant", "Assistant", "Popescu");
        }
}

abstract class User{
    public String firstName, lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

class Student extends User {
    public Parent mother, father;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public boolean isParent(Observer parent) {
        if(parent.equals(mother) || parent.equals(father))
            return true;
        return false;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public void setFather(Parent father) {
        this.father = father;
    }
}

class Parent extends User implements Observer  {
    public ArrayList<Notification> notifications = new ArrayList<>();

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void update(Notification notification) {
        notifications.add(notification);
    }
}

class Assistant extends User implements Element {

    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Teacher extends User implements Element{

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class UserFactory {

    //use getShape method to get object of type shape 
    public static User createUser(String userType, String firstName, String lastName){
        if(userType == null){
            return null;
        }
        if(userType.equalsIgnoreCase("STUDENT")){
            return new Student(firstName, lastName);

        } else if(userType.equalsIgnoreCase("PARENT")){
            return new Parent(firstName, lastName);

        } else if(userType.equalsIgnoreCase("TEACHER")){
            return new Teacher(firstName, lastName);

        } else if(userType.equalsIgnoreCase("ASSISTANT")){
        return new Assistant(firstName, lastName);
    }

        return null;
    }
}
