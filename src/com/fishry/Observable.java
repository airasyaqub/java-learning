package com.fishry;

import java.util.List;
import java.util.function.Consumer;

public class Observable {


    private List<Integer> integerList;


    public Observable( List<Integer> integerList) {
        this.integerList = integerList;
    }





    public void subscribe(Consumer<Integer> consumer) {

        integerList.forEach(consumer::accept);
    }






}
