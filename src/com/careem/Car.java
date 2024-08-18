package com.careem;


public class Car extends Automobile {


    private final String bodyStyle;
    private final int numberOfSeats;
    private final String engineSize;


    // constructor/method overloading also known as static polymorphism

    Car(String make, String color, int year, String model, String bodyStyle, int numberOfSeats, String engineSize) {
        super(make, color, year, model);
        this.numberOfSeats = numberOfSeats;
        this.engineSize = engineSize;
        this.bodyStyle = bodyStyle;
    }

    Car(String bodyStyle, int numberOfSeats, String engineSize) {
        super();
        this.bodyStyle = bodyStyle;
        this.numberOfSeats = numberOfSeats;
        this.engineSize = engineSize;
    }
    

    // method overriding
    @Override
    void giveInfo() {
        super.giveInfo();
        System.out.println("numberOfSeats: " + numberOfSeats);
        System.out.println("engineSize: " + engineSize);
        System.out.println("bodyStyle: " + bodyStyle);
    }

    @Override
    String makeSound(String sound) {
        return sound;
    }


    public static void staticMethod() {
        System.out.println("Hey I am static method used in MethodReference class");
    }

}
