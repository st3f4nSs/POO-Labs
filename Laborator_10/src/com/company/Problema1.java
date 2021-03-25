package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema1 {
    public static void main (String args[]){
        Fereastra b = new Fereastra ("LaboratorPOO");
    }
}

class Fereastra extends JFrame implements ActionListener{
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JButton button;

    public Fereastra (String text){
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.blue);
        setLayout(new FlowLayout());
        button = new JButton ("Apasa");
        button.addActionListener(this);
        add(button);

        field1 = new JTextField(15);
        add(field1);
        field2 = new JTextField(15);
        add(field2);
        field3 = new JTextField(15);
        add(field3);
        field4 = new JTextField(30);
        add(field4);
        setVisible(true);           // show() is deprecated.
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton)e.getSource();
        if (button.getText().equals("Apasa")){
            field4.setText(field1.getText() + "\\" + field2.getText() + "\\" + field3.getText());
        }
    }
}
