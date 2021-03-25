package com.company;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Problema4 {
    public static void main(String args[]) {
        Fereastra4 f4 = new Fereastra4("Laborator POO");
    }
}

class Fereastra4 extends JFrame{
    Vector<Vector<String>> matrix = new Vector<>();

    public Fereastra4(String text) {
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
        scroll.setPreferredSize(new Dimension(300,100));
        add(scroll);


        String data[][] = new String[matrix.size()][4];
        for(int i = 0; i < matrix.size(); i++)
            for(int j = 0; j < 4; j++)
                data[i][j] = matrix.get(i).get(j);
        String column[] = {"File Name", "Dimension", "Last Modified", "Type"};
        JTable jt = new JTable(data, column);
        JScrollPane scroll2 = new JScrollPane(jt);
        add(scroll2);

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
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyey HH:mm:ss");
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
