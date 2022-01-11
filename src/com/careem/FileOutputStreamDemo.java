package com.careem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        FileOutputStreamDemo fileOutputStreamDemo = new FileOutputStreamDemo();
        fileOutputStreamDemo.writeToFile(new File("/home/airas/airas.txt"));
    }

    private void writeToFile(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("Hey there I am writing FileOutputStreamDemo !".getBytes());
        fileOutputStream.write(10);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
