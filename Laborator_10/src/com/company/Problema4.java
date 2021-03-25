package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Problema4 {
    public static void main (String[] args){
        Fereastra4 b = new Fereastra4 ("LaboratorPOO");
    }
}
class Fereastra4 extends JFrame implements ChangeListener {
    private final JSlider slider1;
    private final JSlider slider2;
    private final JSlider slider3;
    private JTextField Red;
    private JTextField Green;
    private JTextField Blue;
    private JTextField Combine;


    public Fereastra4 (String text) {
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.BLACK);
        setLayout(new FlowLayout());

        Red = new JTextField(5);
        Red.setBackground(new Color(226, 12, 12));
        Red.setBorder(BorderFactory.createLineBorder(new Color(226, 12, 12)));
        Red.setEditable(false);
        add(Red);

        slider1 = new JSlider(JSlider.HORIZONTAL,0,255,0);
        slider1.addChangeListener(this);
        add(slider1);

        Green = new JTextField(5);
        Green.setBackground(new Color(0, 191, 23));
        Green.setBorder(BorderFactory.createLineBorder(new Color(0, 191, 23)));
        Green.setEditable(false);
        add(Green);

        slider2 = new JSlider(JSlider.HORIZONTAL,0,255,0);
        slider2.addChangeListener(this);
        add(slider2);

        Blue = new JTextField(5);
        Blue.setBackground(new Color(0, 37, 217));
        Blue.setBorder(BorderFactory.createLineBorder(new Color(0, 37, 217)));
        Blue.setEditable(false);
        add(Blue);

        slider3 = new JSlider(JSlider.HORIZONTAL,0,255,0);
        slider3.addChangeListener(this);
        add(slider3);

        Combine = new JTextField(20);
        Combine.setEditable(false);
        Combine.setBackground(new Color(10, 6, 6));
        add(Combine);

        setVisible(true);
        pack();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
            Combine.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));
    }
}