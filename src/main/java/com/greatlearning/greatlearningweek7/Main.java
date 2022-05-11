package com.greatlearning.greatlearningweek7;

import java.io.*;
import java.util.Scanner;

public class Main {


    public void storeDataInFile(){
        BufferedReader file = null;
        try {
            ReflectionsDemo reflectionsDemo = new ReflectionsDemo();
            file = new BufferedReader(new FileReader("src/main/resources/fileCount.txt"));
            String fileCount = file.readLine();
            int count = Integer.parseInt(fileCount);
            FileWriter fileWriter = new FileWriter("src/main/resources/file" + String.valueOf(count) + ".txt");
            for(String line : reflectionsDemo.textToFile){
                fileWriter.write(line);
            }
            fileWriter.close();
            reflectionsDemo.textToFile.clear();
            count += 1;
            PrintWriter writer = new PrintWriter("src/main/resources/fileCount.txt");
            writer.print("");
            writer.print(count);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPreviousFileData(){
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("src/main/resources/fileCount.txt"));
            String fileCount = null;
            fileCount = file.readLine();
            int count = Integer.parseInt(fileCount);
            for(int i = 0; i <= count; i++){
                file = new BufferedReader(new FileReader("src/main/resources/file"+i+".txt"));
                String line = file.readLine();
                while (line != null){
                    System.out.println(line);
                    line = file.readLine();
                }
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            ReflectionsDemo reflections = new ReflectionsDemo();
            Main main = new Main();
            System.out.println("Welcome to Reflections Demo!");
            System.out.println("Enter the class name: ");
            String className = scanner.next();
            System.out.println("Select option from menu:  ");
            System.out.println("1. Methods");
            System.out.println("2. Class");
            System.out.println("3. Subclasses");
            System.out.println("4. Parent classes");
            System.out.println("5. Constructors");
            System.out.println("6. Data Members");
            int option = scanner.nextInt();
            switch (option){
                case 1: reflections.getMethods(className);
                        break;
                case 2: reflections.getClasses(className);
                        break;
                case 3: reflections.getSubClasses(className);
                        break;
                case 4: reflections.getParentClasses(className);
                        break;
                case 5: reflections.getConstructors(className);
                        break;
                case 6: reflections.getDataMembers(className);
                        break;
                default: break;
            }
            System.out.println("Select option from menu: ");
            System.out.println("1. Store in file");
            System.out.println("2. View previously saved data in other files");
            System.out.println("3. Exit without saving");
            int storeOption = scanner.nextInt();
            switch (storeOption){
                case 1: main.storeDataInFile();
                        break;
                case 2: main.getPreviousFileData();
                        break;
                case 3: break;
            }
        }
    }
}
