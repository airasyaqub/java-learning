package com.careem;

import java.util.Objects;

public abstract class Automobile implements CarCondition {


    private String make;
    private String color;
    private int year;
    private String model;



    Automobile(String make, String color, int year, String model) {
        this.make = make;
        this.color = color;
        this.year = year;
        this.model = model;
    }

    Automobile() {}


    void giveInfo() {
        System.out.println("Manufacturer: " + make);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
    }

    abstract String makeSound(String sound);


    void driftTheCar() {

        // The code defines an anonymous class that implements the interface carCondition, and instantiates that class.
        /* carCondition carCondition = new carCondition() {
            @Override
            public int getConditionScore(String condition) {
                return year;
            }
        };*/

        // System.out.println("testtttttt "+ carCondition.getConditionScore("good"));

        System.out.println("drifting the car which is making sound of " + makeSound("vroom vroom"));
    }

    @Override
    public String isEcoFriendly(String engineType) {
        return Objects.equals(engineType, "hybrid") ? "car is eco friendly" : "car is not eco friendly";
    }

    @Override
    public int getConditionScore(String condition) {
        return Objects.equals(condition, "good") ? 8 : 2;
    }


}
