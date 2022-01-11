package com.fishry;


interface HumanFunctions{

    private static void moveLeftStep() {
        System.out.println("left step moved");
    }

    private static void moveRightStep() {
        System.out.println("right step moved");
    }

    default void walk() {
        HumanFunctions.startWalking();
    }

    static void startWalking() {
        HumanFunctions.moveLeftStep();
        HumanFunctions.moveRightStep();
        System.out.println("walk complete");
    }

    void talk();

}

public class User implements HumanFunctions {

    String name;
    int age;
    String occupation;

    public User(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }


    public String getIntro() {
        return "My name is "+name+". I am "+age+" years old. I am in "+occupation+".";
    }

    @Override
    public void talk() {
        System.out.println("user talking !");
    }
}
