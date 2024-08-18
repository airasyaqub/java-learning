package com.careem.abstraction;

public class Main {

    public static void main(String[] args) {

        Automobile camry = new Toyota("John", 2010, "camry", "red");

        camry.giveInfo();
        camry.paintVehicle();
        camry.testingVehicle();




        Automobile mehran = new Suzuki("Wick", 2022, "mehran", "grey");

        mehran.giveInfo();
        mehran.paintVehicle();
        mehran.testingVehicle();

    }

}
