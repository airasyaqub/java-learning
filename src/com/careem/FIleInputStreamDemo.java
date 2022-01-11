package com.careem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleInputStreamDemo {

    public static void main(String[] args) throws IOException {
        FIleInputStreamDemo fileOutputStreamDemo = new FIleInputStreamDemo();
        fileOutputStreamDemo.readFromFile(new File("/home/airas/airas.txt"));
    }

    private void readFromFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        int charReadFromFile;
        while((charReadFromFile = fileInputStream.read())>=0){
            System.out.println((char)charReadFromFile);
        }
    }
}
