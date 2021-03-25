package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problema6 {
    public static void main (String[] args) {
        Fereastra6 b = new Fereastra6 ("LaboratorPOO");
    }
}

class Fereastra6 extends JFrame implements ActionListener {
    private JButton button;
    private JLabel name;
    private JTextField path;
    private JScrollPane scroll;
    private JTextArea content;

    public Fereastra6 (String text) {
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 300));
        getContentPane().setBackground(Color.WHITE);
        setLayout(new FlowLayout());


        name = new JLabel("Full Path: ");
        add(name);

        path = new JTextField(30);
        path.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(path);

        button = new JButton("Print");
        button.addActionListener(this);
        add(button);

        content = new JTextArea(40,40);
        scroll = new JScrollPane(content);
        scroll.setPreferredSize(new Dimension(500,200));
        add(scroll);
        scroll.setVisible(false);

        setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

            File f = new File(path.getText());
            if (f.exists() && !f.isDirectory()) {
                scroll.setVisible(true);
                Scanner scanner = null;
                try {
                    scanner = new Scanner(f);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                while (scanner.hasNextLine())
                    content.append(scanner.nextLine() + "\n");
                scanner.close();
            }
            SwingUtilities.updateComponentTreeUI(this);
        } else {
                scroll.setVisible(false);
                SwingUtilities.updateComponentTreeUI(this);
        }
    }
}