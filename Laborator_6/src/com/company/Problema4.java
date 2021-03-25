package com.company;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;



class Filter implements FileFilter {
    public static Vector<String> names;
    public static Vector<String> extensii;
    static {
        names = new Vector<>();
        extensii = new Vector<>();
    }

    public void read_names_extensions(String name_path, String ext_path) throws FileNotFoundException {
        Scanner scan_names = new Scanner(new File(name_path));
        Scanner scan_ext = new Scanner(new File(ext_path));

        while (scan_names.hasNextLine()) {
            String line = scan_names.nextLine();
            names.add(line);
        }

        while (scan_ext.hasNextLine()) {
            String line = scan_ext.nextLine();
            extensii.add(line);
        }

    }

    @Override
    public boolean accept(File pathname) {
        int bec1, bec2;
        String file_name;

        bec1 = 0;
        bec2 = 0;
        file_name = pathname.getName();
        for(String j : names) {
            if(file_name.indexOf(j) >= 0)
                bec1 = 1;
        }
        for(String k : extensii) {
            if(file_name.indexOf(k) >=0)
                bec2 = 1;
        }
        if(bec1 == 1 && bec2 == 1) {
            return true;
        }
        return false;
    }
}

class Problema4 {
    public static Vector<String> files;
    public static Vector<File> directory;

    static {
        files = new Vector<>();
        directory = new Vector<>();
    }

    public void get_Directories(File dir_path) throws FileNotFoundException {

        File [] Files=dir_path.listFiles();
        if (Files == null)
            return;
        for(int i = 0; i < Files.length; i++)
            if (Files[i].isDirectory()) {
                directory.add(Files[i]);
                get_Directories(Files[i]);
            }
    }

    public void get_All_Files() throws FileNotFoundException {
        Problema4 obj = new Problema4();
        Filter filter = new Filter();

        obj.get_Directories(new File("C://Users//Stefan//Desktop//Arhiva6//director"));
        for(File i : directory) {
            File [] Files = i.listFiles(filter);
            for(int j = 0; j < Files.length; j++)
                files.add(Files[j].getName());
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Problema4 obj = new Problema4();
        Filter filter = new Filter();

        filter.read_names_extensions("C://Users//Stefan//Desktop//Arhiva6//words.in",
                                    "C://Users//Stefan//Desktop//Arhiva6//extension.in");
        obj.get_All_Files();
        for(String i : files)
            System.out.println(i);
    }
}
