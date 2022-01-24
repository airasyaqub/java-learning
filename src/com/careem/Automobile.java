package com.careem;

import java.util.Objects;

public abstract class Automobile implements carCondition {


    private String make = "";
    private String color = "";
    private int year = 0;
    private String model = "";



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


    /*@Override
    public String isEcoFriendly(String engineType) {`
        return Objects.equals(engineType, "hybrid") ? "car is eco friendly" : "car is not eco friendly";
    }*/

    @Override
    public int getConditionScore(String condition) {
        return Objects.equals(condition, "good") ? 8 : 2;
    }


}
