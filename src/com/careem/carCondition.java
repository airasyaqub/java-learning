package com.careem;

public interface carCondition {

    int getConditionScore(String condition);

    default void initiatedInterfaceClass() {
        System.out.println("Welcome to carCondition class");
    }

}
