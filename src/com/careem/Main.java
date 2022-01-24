package com.careem;
import com.fishry.User;


import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    /*
    // access modifiers
    final int myDefaultInt = 2; // visible to every class package
    public int myPublicInt = 2; // visible to world
    protected int myProtectedInt = 2; // visible to every class in package and all the subclasses of Main class
    private int myPrivateInt = 2; // visible to only within class
    */
    public static void main(String[] args) {


        /*
        // primitive data types
        byte myByte = 127; // 1 byte	Stores whole numbers from -128 to 127
        short myShort = 32_767; // 2 bytes	Stores whole numbers from -32,768 to 32,767
        int myInt = 10; // 4 bytes Stores whole numbers from -2,147,483,648 to 2,147,483,647
	    long myLong = 300_0000_0000L; // 8 bytes Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        float myFloat = 10.1234561F; // 4 bytes Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
        double myDouble = 10.123456*1F; // 8 bytes Stores fractional numbers. Sufficient for storing 15 decimal digits
        boolean myBoolean = true;	// 1 bit	Stores true or false values
        char myChar = 'a'; 	// 2 bytes	Stores a single character/letter or ASCII values

        // non-primitive data types
        String myStr = "John";
        StringBuffer myStrBuffer =new StringBuffer("JOhn");
        System.out.println(myStrBuffer.substring(2));
        int[][] myArr = { {1, 8, 9, 10}, {2, 3, 7, 20} };
        String[] name = {"doe", "ahmed", "ksa", "john"};
        */
        // ------------------------------------------------------------------------------------>



        // date in java
        /* Date myDate = new Date();
        System.out.println("today is " + tod.getTime()); */

        // ------------------------------------------------------------------------------------>


        // STRINGS in java
        // java strings are stored in string pool of heap memory area. One pool can have multiple strings.
        // When we create string object, the object name (variable) will be stored/created in
        // execution context (stack portion of memory) & the value we are assigning to that variable
        // will be stored in string pool (portion of heap memory).


        // STRINGBUFFER is used to create mutable string. It is also thread safe.
        // STRINGBUILDER is not thread safe so it is faster

        /* String myStr = "   John is a very grumpy guy  ";
        System.out.println(myStr.trim()); */

        // ------------------------------------------------------------------------------------>


        // arrays in java
        /* int[][] myArr = { {1, 9, 2, 7}, {2, 1, 23, 20} };
        String[] myName = {"mike", "ahmed", "doe", "john"};
        for (int i = 0; i < myArr.length; i++) {
            Arrays.sort(myArr[i]);
            System.out.println(Arrays.toString(myArr[i]));
        }
        for (String name: myName){
            System.out.println(name);
        }

        int[] arr = new int[5];
        arr[3] = 3;
        for ( int elem: arr ) {
            System.out.println(elem);
        }
        */


        // ------------------------------------------------------------------------------------>

        // explicit & implicit type
        // do check type conversion methods too

        /*
        int myInt;
        byte myByte = 12;
        myInt = myByte;

        double myDouble = (double)10/(double)3;
        myDouble++;
        System.out.println(myDouble);


        double myDouble = 1.1;
        int myInt = (int)myDouble + 2;

        String myStr = "1.1";
        double myDouble = Double.parseDouble(myStr) + 2;
        System.out.println(myDouble);


        double myDouble = (int) (Math.random() * 100);
        System.out.println(myDouble);
        */

        // -------------------------------------------------------------------------------------->

        /*
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String res = currency.format(0.112);
        System.out.println(res);
        */


        // -------------------------------------------------------------------------------------->

        // a program to calculate mortgage

        /*
        final int MONTH_IN_YEAR = 12;
        final int PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual interest rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

        System.out.print("Period (Years): ");
        int years = scanner.nextInt();
        int numberOfPayments = years * MONTH_IN_YEAR;

        double mortgage;
        mortgage = (principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String finalRes = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + finalRes);
        */

        // -------------------------------------------------------------------------------------->

        // a simple FizzBuzz program

        /*
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");

        int num = scanner.nextInt();

        if((num%5 == 0) && (num%3 == 0)) {
            System.out.println("FizzBuzz");
        } else if (num%5 == 0) {
            System.out.println("Fizz");
        } else if (num%3 == 0 ) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
        */

        // -------------------------------------------------------------------------------------->


        /*
        Main myMain = new Main();
        myMain.greaterThanTwo(new int[]{1, 2, 3, 4, 5});
        printingSomething(); // will give error because we can't call non-static method from static one directly
        */


        // -------------------------------------------------------------------------------------->

        // copying one array to other

        /*
        char[] source = {'H', 'A', 'P', 'P', 'Y', 'L', 'E', 'A', 'R', 'N', 'I', 'N', 'G'};
        char[] destination = new char[7];
        System.arraycopy(source, 0, destination, 1, 5);
        System.out.println(Arrays.toString(destination));
        System.out.println(destination[0]);
        */


        // -------------------------------------------------------------------------------------->

        // reduce & map in JAVA
        // https://www.sitepoint.com/java-8-streams-filter-map-reduce/

        /*
        int[] arr = {2, 3, 4, 8 ,3};
        int resReduce = Arrays.stream(arr).reduce(1, (a, b) -> a*b);
        IntStream resMap = Arrays.stream(arr).map(e -> e*2);
        System.out.println(Arrays.toString(resMap.toArray()));
        System.out.println(resReduce);
        */

        // -------------------------------------------------------------------------------------->



        // will not be initialized as abstract class cannot be initialized!
        // Automobile car = new Automobile("660cc", 4);


        /*Car elantra = new Car("Hyundai",
                            "Red",
                            2019,
                            "Elantra",
                            "sedan",
                            4,
                            "2000cc");
        elantra.giveInfo();


        // method over-riding is run time polymorphism, here giveInfo of car will be called even we have
        // assigned mira Automobile type.During compile time JVM wouldn't have knowledge of which giveInfo will be called

        Automobile mira = new Car("sedan", 4, "2000cc");
        mira.giveInfo();

        // interface method returning an interface
        System.out.println(elantra.checkCarEco().isEcoFriendly("hybrid"));
        System.out.println("car score is "+elantra.getConditionScore("good"));
        System.out.println(elantra.makeSound("vroom vroom"));
        System.out.println(elantra.makeSound("vroom vroom vroom"));
        elantra.initiatedInterfaceClass();

        User john = new User("John", 26, "IT");
        System.out.println(john.getIntro());
        john.walk();
        john.talk();*/


        // -------------------------------------------------------------------------------------->


        // exception handling "throws" is used to suppress exception!

        /*try {
            // System.out.println(29/0);
            throw new Exception("my custom error occurred");
        }catch (Exception exception) {
            System.out.println("an exception occurred in: "+exception.getMessage());
        }*/


        // -------------------------------------------------------------------------------------->

        // generics in java
        // https://www.geeksforgeeks.org/generics-in-java/


        // -------------------------------------------------------------------------------------->

        // Default constructor: A constructor which is implicitly put by JVM without any params
        // even if we don't mention it in our class. It is used to provide default values
        // to attribute depending on type.

        // constructor chaining: 3:16:00 of https://www.youtube.com/watch?v=hBh_CC5y8-s&t=35823s

        // static variables are stored in a space known as permanent generation memory.


        // -------------------------------------------------------------------------------------->


        // single inheritance, Hierarchical inheritance, multilevel inheritance

        // When you have a class as property in a class it's a HAS-A relationship. EMPLOYEE has a NAME.

    }





    public <T> ArrayList<T> makeArray(int size) {
        return new ArrayList<T>(size);
    }

    private void greaterThanTwo(int[] arr) {
        IntStream res =  Arrays.stream(arr).filter(e -> e>2);
        printingSomething();
        System.out.println(Arrays.toString(res.toArray()));
    }

    private void printingSomething() {
        System.out.println("Java is fast !");
    }


}