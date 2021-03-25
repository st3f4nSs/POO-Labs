package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problema5 {
    public static void main(String args[]) throws FileNotFoundException {
        Director dir = new Director("./Lab11");
        Cat fct = new Cat();
        fct.visit(new Fisier("./Lab11\\ana_are_mere.txt"));
        Ls ls = new Ls();
        ls.visit(dir);
    }
}

interface Visitor {
    void visit (Director f);
    void visit (Fisier f) throws FileNotFoundException;
}
class Ls implements Visitor {
    public void visit (Director f) {
        System.out.println(f.getName());
        for (Repository repo: f.getChildren()) {
            System.out.println("\t" + repo.getName());
            // afisam numele unui repo (fisier / folder)
        }
    }
    public void visit (Fisier f) {
        System.out.println("Not a folder");
                  /* comanda Ls (in acest exemplu) este specifica doar folderelor,
                  in acest caz este evidentiat un dezavantaj al  Visitor-ului,
                  faptul ca noi trebuie sa implementam metode de care nu avem nevoie
                  in acest caz - se incalca Interface Segregation Principle  */
    }
}
class Cat implements Visitor {
    public void visit (Director f) {
        System.out.println("Not a file");
        // avertisment ca avem folder, nu fisier
    }
    public void visit (Fisier f) throws FileNotFoundException {
        File file = new File(f.getPath());
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext())
            System.out.println(scanner.nextLine());
    }
}
abstract class Repository {
    private String name;

    public Repository(String name) {
        this.name = name;
    }

    public Repository() {
        this("");
    }
    // numele unui fisier sau folder (de fapt, calea acestuia)
    public String getName() {
        String names[] = name.split("\\\\");
        return names[names.length - 1];
    }

    public String getPath() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract void accept (Visitor f) throws FileNotFoundException;
}
class Fisier extends Repository {
    public Fisier(String name) {
        super(name);
    }

    public Fisier() {
        super();
    }

    public void accept (Visitor f) throws FileNotFoundException {
        f.visit(this);
        // Visitor-ul "viziteaza" fisierul, adica acesta
        //efectueaza o operatie asupra fisierului
    }
}
class Director extends Repository {
    private List<Repository> children = new ArrayList<>();

    public Director(String pathname) {
        super(new File(pathname).getName());
        File dir = new File(pathname);


        File[] continut = dir.listFiles();
        if(continut != null) {
            for(File file : continut) {
                if(file.isFile()) {
                    Fisier fisier = new Fisier(file.getPath());
                    this.addChild(fisier);
                } else if (file.isDirectory()) {
                    Director director= new Director(pathname + "\\" + file.getName());
                    this.addChild(director);
                }
            }
        }
    }

    public List<Repository> getChildren() {
        return children;
    }
    public void accept (Visitor f) {
        f.visit(this);
    }

    public void addChild(Repository repository) {
        children.add(repository);
    }

}
