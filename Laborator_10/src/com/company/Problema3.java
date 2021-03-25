package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

class Problema3 {
    public static void main (String args[]) throws FileNotFoundException {
        Fereastra3 b = new Fereastra3("LaboratorPOO");
        // First and third are correct.
    }
}

class Fereastra3 extends JFrame implements ItemListener,ActionListener{
    private JTextField question;
    private JCheckBox choice1;
    private JCheckBox choice2;
    private JCheckBox choice3;
    private JCheckBox choice4;
    private JButton button;
    private JTextField answer;

    public Fereastra3 (String text) throws FileNotFoundException {
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.blue);
        setLayout(new FlowLayout());
        answer = new JTextField(30);
        answer.setText("Alegeti raspunsul/ raspunsurile corecte.");

        File f = new File("C:\\Users\\Stefan\\Desktop\\intrebare.txt");
        Scanner scanner = new Scanner(f);
        Vector<String> files = new Vector<>();
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            files.add(str);
        }
        question = new JTextField(files.get(0), files.get(0).length() / 2 + 10);
        add(question);

        choice1 = new JCheckBox(files.get(1));
        add(choice1);
        choice2 = new JCheckBox(files.get(2));
        add(choice2);
        choice3 = new JCheckBox(files.get(3));
        add(choice3);
        choice4 = new JCheckBox(files.get(4));
        add(choice4);
        add(answer);
        button = new JButton ("Click");
        button.addActionListener(this);
        button.setEnabled(false);

        choice1.addItemListener(this);
        choice2.addItemListener(this);
        choice3.addItemListener(this);
        choice4.addItemListener(this);
        add(button);
        setVisible(true);           // show() is deprecated.
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.button)
        {
            if(choice1.isSelected() && !choice2.isSelected() && choice3.isSelected() && !choice4.isSelected())
                answer.setText("Raspuns corect!");
            else
                answer.setText("Raspuns gresit!");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() instanceof JCheckBox)
            button.setEnabled(true);


        if(!choice1.isSelected() && !choice2.isSelected() && !choice3.isSelected() && !choice4.isSelected()) {
            button.setEnabled(false);
            answer.setText("Alegeti raspunsul/ raspunsurile corecte!");
        }

    }
}