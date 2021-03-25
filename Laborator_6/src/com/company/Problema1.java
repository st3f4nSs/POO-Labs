package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

abstract class  Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this("white", false);
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        radius = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle( double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        if(isFilled())
            return "Cercul de raza " + radius + ", culoare " + this.getColor() + " umplut.";
        else
            return "Cercul de raza " + radius + ", culoare " + this.getColor() + " neumplut.";
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        width = 0;
        length = 0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        if(isFilled())
            return "Dreptunghiul cu lungime de " + length + " si latimea de " + width +
                    ", culoarea " + this.getColor() + ", umplut.";
        else
            return "Dreptunghiul cu lungime de " + length + " si latimea de " + width +
                    ", culoarea " + this.getColor() + ", neumplut.";
    }
}

class Square extends Rectangle {

    public Square() {
        setWidth(0);
        setLength(0);
    }

    public Square(double side) {
        setWidth(side);
        setLength(side);
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }

    public void setWidth(double side) {
        super.setWidth(side);
    }

    public void setLength(double side) {
        super.setLength(side);
    }

    public String toString() {
        if(isFilled())
            return "Patrat cu latura de " + getLength() +
                    ", culoarea " + this.getColor() + ", umplut.";
        else
            return "Patrat cu latura de " + getLength() +
                    ", culoarea " + this.getColor() + ", neumplut.";
    }
}

class Test01 {
    public static void main(String args[]) {
        boolean ok = true;
        //Verificarea relatiilor de mostenire
        Shape obj1;
        obj1 = new Square();
        obj1 = new Rectangle();
        obj1 = new Circle();
        Rectangle obj3 = new Square();
        //Verificarea constructorilor
        Constructor[] allConstructors = Square.class.getDeclaredConstructors();
        if(allConstructors.length != 3) {
            System.out.println("Clasa Square NU are definiti toti constructorii!");
            ok = false;
        }
        Circle circle = new Circle(2.0, "green", true);
        Square square = new Square(5.0, "black", true);
        if(!Modifier.isAbstract(Shape.class.getModifiers())) {
            System.out.println("Clasa Shape NU este abstracta!");
            ok = false;
        }
        if(!Shape.class.isAssignableFrom(Square.class) && !Rectangle.class.isAssignableFrom(Square.class)) {
            System.out.println("Clasele NU respecta relatia de mostenire descrisa!");
            ok = false;
        }
        if(!circle.isFilled() || !circle.getColor().equals("green")) {
            System.out.println("Constructorul din clasa Circle NU este definit conform specificatiilor!");
            ok = false;
        } else if(!square.isFilled() || !square.getColor().equals("black") || square.getWidth() != square.getLength()) {
            System.out.println("Constructorul din clasa Square NU este definit conform specificatiilor!");
            ok = false;
        } else if(ok){
            System.out.println("Au trecut toate testele!");
        }
    }
}
