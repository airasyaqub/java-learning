package com.careem.abstraction;

public class Toyota extends Automobile {


    private String ceoName;




    public Toyota(String ceoName, Integer model, String make, String color) {
        super(model, make, color);
        this.ceoName = ceoName;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    @Override
    protected void testingVehicle() {

        if (this.getShipped()) {
            System.out.println("Toyota way of testing vehicle");
        } else {
            System.out.println("Toyota is not shipped yet so cannot test");
        }

    }


    @Override
    public void giveInfo() {
        super.giveInfo();
        System.out.println("ceoName: " + ceoName);
    }







}
