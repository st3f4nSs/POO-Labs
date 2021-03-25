package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Problema5 {
    public static void main(String args[]) {
        Fereastra5 f5 = new Fereastra5("Laborator POO");
    }
}

class Fereastra5 extends JFrame{
    Vector<Vector<String>> matrix = new Vector<>();

    public Fereastra5(String text) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 300));
        getContentPane().setBackground(Color.GRAY);
        setLayout(new GridLayout(1, 2));

        File file = new File("C:\\Users\\Stefan\\Desktop\\Lab11");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName());
        createChildren(file, root);
        JTree tree = new JTree(root);
        JScrollPane scroll = new JScrollPane(tree);
        scroll.setPreferredSize(new Dimension(300,400));
        add(scroll);


        String data[][] = new String[matrix.size()][4];
        for(int i = 0; i < matrix.size(); i++)
            for(int j = 0; j < 4; j++)
                data[i][j] = matrix.get(i).get(j);
        String column[] = {"File Name", "Dimension", "Last Modified", "Type"};
        JTable table = new JTable(data, column);
        JScrollPane scroll2 = new JScrollPane(table);
        //add(scroll2);

        JTextField text1 = new JTextField(3);
        JTextField text2 = new JTextField(3);
        text1.setEditable(false);
        text2.setEditable(false);

        ListSelectionModel rowSM = table.getSelectionModel();
        ListSelectionModel colSM = table.getColumnModel().getSelectionModel();

        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

               text1.setText(String.valueOf(rowSM.getMinSelectionIndex()));
            }
        });
        colSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                text2.setText(String.valueOf(colSM.getMinSelectionIndex()));
            }
        });
        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.setBackground(Color.GRAY);
        JPanel panel2 = new JPanel(new FlowLayout());
        panel.setBackground(Color.GRAY);
        JLabel l1 = new JLabel("Row: ");
        JLabel l2 = new JLabel("Column: ");
        panel.add(scroll2);
        panel2.add(l1);
        panel2.add(text1);
        panel2.add(l2);
        panel2.add(text2);
        panel.add(panel2);
        JScrollPane scroll3 = new JScrollPane(panel);
        add(scroll3);
        setVisible(true);
        pack();
    }
    private void createChildren(File root, DefaultMutableTreeNode node) {
        File[] files = root.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if(file.isFile()) {
                Vector<String> line = new Vector<>();
                line.add(file.getName());
                Long dimension = file.length() / 1024;
                line.add(dimension.toString());
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                line.add(sdf.format(file.lastModified()));
                line.add("File");
                matrix.add(line);

                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
                node.add(childNode);
            } else if(file.isDirectory()) {
                Vector<String> line = new Vector<>();
                line.add(file.getName());
                line.add("0");  // sau FileUtils.sizeOfDirectory(dir) dar trebuie instalata biblioteca Apache
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                line.add(sdf.format(file.lastModified()));
                line.add("Folder");
                matrix.add(line);

                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
                node.add(childNode);
                createChildren(file, childNode);
            }
        }
    }
}
