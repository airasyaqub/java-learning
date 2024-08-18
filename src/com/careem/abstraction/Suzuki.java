package com.careem.abstraction;

public class Suzuki extends Automobile{

    private String ceoName;


    public Suzuki(String ceoName, Integer model, String make, String color) {
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
            System.out.println("Suzuki way of testing vehicle");
        } else {
            System.out.println("Suzuki is not shipped yet so cannot test");
        }
    }


    @Override
    public void giveInfo() {
        super.giveInfo();
        System.out.println("ceoName: " + ceoName);
    }


    @Override
    protected void shipVehicle() {
        System.out.println(this);
        System.out.println(this.getMake() + " is being shipped to testing area in circuit after color");
        this.setShipped(true);
    }
}
