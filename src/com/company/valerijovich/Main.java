package com.company.valerijovich;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<File> fileArrayList = new ArrayList<>();
        searchFiles(new File("C:\\users\\admin\\downloads"), fileArrayList);
        for (File file : fileArrayList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void searchFiles(File rootFile, List<File> fileList) {

        if (rootFile.isDirectory()) {
            System.out.println("Now I am searching in the directory: ");
            File[] fileDirectory = rootFile.listFiles();
            if (fileDirectory != null) {
                for (File file : fileDirectory) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg"))
                            fileList.add(file);
                    }
                }
            }
        }
    }
}
