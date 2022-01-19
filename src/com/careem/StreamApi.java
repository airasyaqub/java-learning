package com.careem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {

        StreamApi streamApi = new StreamApi();


        // immutable
        // List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // immutable
        // List<Integer> arrayList = List.of(1, 2, 3, 4, 5, 6, 7, 8);


        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        arrayList.add(12);
        arrayList.add(83);


        System.out.println(arrayList);


        arrayList = arrayList.stream().filter((Integer e) ->
            {
                return e > 50;
            }
        ).toList();;

        // arrayList = stream.filter(e -> e % 2 == 0).toList();

        System.out.println(arrayList);


    }


}
