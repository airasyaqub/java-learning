package com.careem;

import java.io.*;
import java.util.Scanner;

public class FileWriterDemo {


    public static void main(String[] args) {

        // file read/write
        File myFile = new File("/home/airas/airas.txt");
        FileWriterDemo ourFileWriter = new FileWriterDemo();
        ourFileWriter.writeFile(myFile);
        try {
            ourFileWriter.readFile(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found "+myFile.getName());
        }

    }


    private void writeFile(File fileToWrite) {

        // https://medium.com/geekculture/using-printwriter-vs-filewriter-in-java-2958df85f105

        // using FileWriter
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileToWrite);
            fileWriter.write("Vinod");
            fileWriter.write("How are you !");
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException exception) {
            System.out.println(fileToWrite.getName());
        }


        // using PrintWriter
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(fileToWrite);
            printWriter.write("Vinod");
            printWriter.println();
            printWriter.write("How are you !");
            printWriter.println();
        }catch (FileNotFoundException exception) {
            System.out.println(fileToWrite.getName());
        } finally {
            printWriter.close();
        }
    }


    private void readFile(File fileToRead) throws FileNotFoundException {
        Scanner input = new Scanner(fileToRead);
        while(input.hasNext()) {
            System.out.println(input.nextLine());
        }
    }




}
