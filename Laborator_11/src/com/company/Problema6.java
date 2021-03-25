package com.company;

import javax.swing.*;
import java.awt.*;

public class Problema6 {
    public static void main(String args[]) {

        Fereastra6 f = new Fereastra6("Laborator POO");
    }
}

class Fereastra6 extends JFrame{
    private JList<Book6> myJlist;

    public Fereastra6(String text) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        getContentPane().setBackground(Color.GRAY);
        setLayout(new FlowLayout());

        DefaultListModel<Book6> model = new DefaultListModel<>();
        myJlist = new JList<Book6>();
        model.addElement(new Book6("C/C++ Programming", "Author 1", "cpp"));
        model.addElement(new Book6("Java Programming", "Author 2", "java"));
        model.addElement(new Book6("C# Programming", "Author 3", "cs"));
        model.addElement(new Book6("IOS Programming", "Author 4", "ios"));
        model.addElement(new Book6("Windows Phone Programming", "Author 5", "wp"));
        model.addElement(new Book6("Android Programming", "Author 6", "android"));
        myJlist.setModel(model);
        myJlist.setCellRenderer(new BookRenderer());
        add(myJlist);

        setVisible(true);
        pack();
    }

}

class Book6 {
    private String name;
    private String author;
    private String iconName;

    public Book6(String name, String author, String iconName) {
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

class BookRenderer extends JPanel implements ListCellRenderer<Book6> {
    JLabel icon = new JLabel();
    JLabel title = new JLabel();
    JLabel author = new JLabel();


    @Override
    public Component getListCellRendererComponent(JList<? extends Book6> list, Book6 value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel title_author = new JPanel(new GridLayout(2, 1));
        String iconName = value.getIconName();
        ImageIcon imageIcon = new ImageIcon("Imagini/" + iconName + ".jpg");

        title_author.add(title);
        title_author.add(author);
        icon.setIcon(imageIcon);
        title.setText(value.getName());
        author.setText(value.getAuthor());
        panel.add(icon);
        panel.add(title_author);
        /*if (isSelected) {
            panel.setBackground(Color.RED);
            title_author.setBackground(Color.RED);

        } else {
            if(index % 2 == 0) {
                panel.setBackground(Color.GREEN);
                title_author.setBackground(Color.GREEN);
            }
            else{
                panel.setBackground(Color.YELLOW);
                title_author.setBackground(Color.YELLOW);
            }
        }

         */
        panel.setPreferredSize(new Dimension(400, 90));

        return panel;
    }
}
