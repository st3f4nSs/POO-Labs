package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class Problema5 {
    public static void main (String args[]){
        Fereastra5 b = new Fereastra5 ("LaboratorPOO");
    }
}

class Fereastra5 extends JFrame implements ActionListener{
    private JButton button;
    private Vector<Color> colors;
    private int iterator;
    {
        colors = new Vector<>();
        iterator = 0;
    }

    public Fereastra5 (String text){
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200, 200));
        getContentPane().setBackground(Color.BLACK);
        setLayout(new FlowLayout());
        button = new JButton ("Colors");
        button.addActionListener(this);
        add(button);
        button.setMnemonic(KeyEvent.VK_C);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);

        setVisible(true);           // show() is deprecated.
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton)e.getSource();
        if (button.getText().equals("Colors")){
            if(iterator >= colors.size())
                iterator = 0;
            button.setForeground(colors.get(iterator));
            iterator++;
        }
    }
}
