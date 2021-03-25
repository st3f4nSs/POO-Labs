package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

class Problema2 {
    public static void main (String args[]) throws FileNotFoundException {
        Fereastra2 b = new Fereastra2("LaboratorPOO");
    }
}

class Fereastra2 extends JFrame implements ActionListener{
    private JTextField question;
    private JRadioButton choice1;
    private JRadioButton choice2;
    private JRadioButton choice3;
    private JRadioButton choice4;
    private JButton button;
    private ButtonGroup choices;

    public Fereastra2 (String text) throws FileNotFoundException {
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.blue);
        setLayout(new FlowLayout());
        choices = new ButtonGroup();

        File f = new File("C:\\Users\\Stefan\\Desktop\\intrebare.txt");
        Scanner scanner = new Scanner(f);
        Vector<String> files = new Vector<>();
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            files.add(str);
        }
        question = new JTextField(files.get(0), files.get(0).length() / 2 + 3);
        add(question);
        choice1 = new JRadioButton(files.get(1));
        add(choice1);
        choice2 = new JRadioButton(files.get(2));
        add(choice2);
        choice3 = new JRadioButton(files.get(3));
        add(choice3);
        choice4 = new JRadioButton(files.get(4));
        add(choice4);

        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);
        choices.add(choice4);


        button = new JButton ("Click");
        button.addActionListener(this);
        button.setEnabled(false);

        choice1.addActionListener(this);
        choice2.addActionListener(this);
        choice3.addActionListener(this);
        choice4.addActionListener(this);
        add(button);
        setVisible(true);           // show() is deprecated.
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() instanceof JRadioButton){
            button.setEnabled(true);
        }
        else {
            if(choice1.isSelected())
                choice1.setBackground(Color.green);
            else
                choice1.setBackground(Color.red);
        }
    }
}