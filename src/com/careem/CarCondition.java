package com.careem;

import java.util.Objects;

public interface CarCondition extends IsEco {

    int getConditionScore(String condition);

    default void initiatedInterfaceClass() {
        System.out.println("Welcome to carCondition class");
    }

    /*
    default isEco checkCarEco() {
        return new isEco() {
            @Override
            public String isEcoFriendly(String engineType) {
                return Objects.equals(engineType, "hybrid") ? "car is eco friendly" : "car is not eco friendly";
            }
        };
    }
    */
}
