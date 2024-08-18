package com.careem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PlayGround {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {




        Integer num = 2345;

        String str = String.valueOf(num);

        String[] stringArray = str.split("");


        int res = 0;

        for (String s : stringArray) {
            res += Integer.parseInt(s);
        }

        System.out.println(res);

//
//        Supplier<Integer> orderFetch = () -> {
//            System.out.println("fetching order number");
//
//            delay(2000);
//            throw new RuntimeException("order fetch  failed");
//        };
//
//
//        Function<Integer, Boolean> inventoryCheck = (orderId) -> {
//            System.out.println("inventory check");
//
//            delay(3000);
//
//            return orderId % 2 == 0;
//        };
//
//
//        Function<Boolean, String> paymentCheck = (isInInventory) -> {
//            System.out.println("inventory check");
//
//            delay(3000);
//
//            return isInInventory ? "success" : "fail";
//        };
//
//
//        CompletableFuture<String> orderStatus = CompletableFuture.supplyAsync(orderFetch).thenApply(inventoryCheck).thenApply(paymentCheck).exceptionally(throwable -> {
//            System.out.println("exception happened: " + throwable.getMessage());
//            return null;
//        });
//
//
//        String res = orderStatus.join();
//
//        System.out.println(res);
//
//        System.out.println("program end");


    }


    static void delay(Integer ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
