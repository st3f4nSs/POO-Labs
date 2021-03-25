package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Problema1 {
    public static void main(String args[]) {
        Fereastra1 f = new Fereastra1("Laborator POO");
    }
}

class Fereastra1 extends JFrame{

    public Fereastra1(String text) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        getContentPane().setBackground(Color.BLUE);
        setLayout(new FlowLayout());

        Vector<Book> books = new Vector<>();
        books.add(new Book("Colt Alb", "Jack London", ""));
        books.add(new Book("Singur pe lume", "Hector Malot", ""));
        books.add(new Book("Scrinul Negru", "George Calinescu", ""));
        books.add(new Book("Morometii", "Marin Preda", ""));
        books.add(new Book("Amintiri din copilarie", "Ion Creanga", ""));
        books.add(new Book("Moara cu noroc", "Ioan Slavici", ""));
        books.add(new Book("Povestea lui Harap-Alb", "Ion Creanga", ""));

        JList<Book> myJlist = new JList<>(books);
        myJlist.setBorder(BorderFactory.createEmptyBorder());
        JScrollPane scroll = new JScrollPane(myJlist);
        scroll.setPreferredSize(new Dimension(400,100));
        add(scroll);
        setVisible(true);           // show() is deprecated.
        pack();
    }
}

class Book {
    private String name;
    private String author;
    private String iconName;

    public Book(String name, String author, String iconName) {
        this.name = name;
        this.author = author;
        this.iconName = iconName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", author='" + author + '\'';
    }
}

