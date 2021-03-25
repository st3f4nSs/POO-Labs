package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema3 {
    public static void main(String args[]) {
        Fereastra3 f = new Fereastra3("Laborator POO");
    }
}

class Fereastra3 extends JFrame implements ListSelectionListener, ActionListener {
    private JLabel author;
    private JLabel name;
    private JTextField author_text;
    private JTextField name_text;
    private JList<Book3> myJlist;
    private JButton button;

    public Fereastra3(String text) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 200));
        getContentPane().setBackground(Color.GRAY);
        setLayout(new GridLayout(3, 1));

        author = new JLabel("Author name: ");
        author_text = new JTextField(20);
        author_text.setEditable(false);

        name = new JLabel("Book name: ");
        name_text = new JTextField(20);
        name_text.setEditable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.add(author);
        panel.add(author_text);
        panel.add(name);
        panel.add(name_text);
        
        button = new JButton("Remove");
        button.addActionListener(this);


        DefaultListModel<Book3> model = new DefaultListModel<>();
        model.addElement(new Book3("Colt Alb", "Jack London", ""));
        model.addElement(new Book3("Singur pe lume", "Hector Malot", ""));
        model.addElement(new Book3("Scrinul Negru", "George Calinescu", ""));
        model.addElement(new Book3("Morometii", "Marin Preda", ""));
        model.addElement(new Book3("Amintiri din copilarie", "Ion Creanga", ""));
        model.addElement(new Book3("Moara cu noroc", "Ioan Slavici", ""));
        model.addElement(new Book3("Povestea lui Harap-Alb", "Ion Creanga", ""));
        myJlist = new JList<>(model);
        myJlist.addListSelectionListener(this);
        JScrollPane scroll = new JScrollPane(myJlist);
        scroll.setPreferredSize(new Dimension(300,100));
        add(scroll);
        add(panel);
        add(button);
        
        setVisible(true);           // show() is deprecated.
        pack();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(myJlist.isSelectionEmpty())
            return;
        author_text.setText(myJlist.getSelectedValue().getAuthor());
        name_text.setText(myJlist.getSelectedValue().getName());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        if (button.getText().equals("Remove")){
            DefaultListModel<Book3> model = (DefaultListModel<Book3>) myJlist.getModel();
            int selected_index = myJlist.getSelectedIndex();
            if(selected_index != -1)
                model.removeElement(myJlist.getSelectedValue());
        }
    }
}

class Book3 {
    private String name;
    private String author;
    private String iconName;

    public Book3(String name, String author, String iconName) {
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

