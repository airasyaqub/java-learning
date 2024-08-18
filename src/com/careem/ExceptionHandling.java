package com.careem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {


    public static void main(String[] args) {


        // simpleException();

        userdefinedException();

        /*try {
            propagationException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurs");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException occurs");
        }*/

    }

    private static void simpleException(){
        /* simple try catch example */
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException in method");
        }
    }

    private static void propagationException() throws FileNotFoundException {

        /* propagation example */

        /* This unchecked exception will propagate to callstack by using only throw keyword */
        throw new NullPointerException();


        /* Here to propagate checked exception to callstack we can't just use throw, we have to use throws with it too.*/
        // throw new FileNotFoundException();

    }

    private static void userdefinedException(){

        try {
            throw new MyException(3);
        } catch (MyException e) {
            System.out.println(e);
        }
    }

    static class MyException extends Exception {

        int a;

        MyException(int num) {
            a = num;
        }

        @Override
        public String toString() {
            return ("Exception number = "+a);
        }
    }

}

