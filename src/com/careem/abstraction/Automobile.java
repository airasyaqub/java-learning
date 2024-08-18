package com.careem.abstraction;

public abstract class Automobile {


    private Integer model;
    private String make;
    private String color;

    private Boolean shipped = false;

    public Automobile(Integer model, String make, String color) {

        this.model = model;
        this.make = make;
        this.color = color;

    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Boolean getShipped() {
        return shipped;
    }

    public void setShipped(Boolean shipped) {
        this.shipped = shipped;
    }


    protected void giveInfo() {
        System.out.println("Name: " + make);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
    }


    // Default is to ship vehicle to testing are in FACTORY after color

    protected void paintVehicle() {
        System.out.println(this);
        System.out.println(make + " is being painted with color " + color);
        shipVehicle();
    }


    protected void shipVehicle() {
        System.out.println(this);
        System.out.println(make + " is being shipped to testing area in factory after color");
        shipped = false;
        // testingVehicle();
    }

    protected abstract void testingVehicle();


}
