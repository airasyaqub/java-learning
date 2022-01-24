package com.careem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;



// stream is used to process collection of objects

public class StreamApi {

    public static void main(String[] args) {

        StreamApi streamApi = new StreamApi();


        // immutable
        // List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // immutable
        // List<Integer> arrayList = List.of(1, 2, 3, 4, 5, 6, 7, 8);


        // mutable
        // stream from array list
        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        arrayList.add(12);
        arrayList.add(83);
        arrayList = arrayList.stream().filter((Integer e) ->
            {
                return e > 50;
            }
        ).toList();;
        System.out.println(arrayList);


        // stream from array
        // https://stackoverflow.com/questions/40902315/java-stream-toarray-convert-to-a-specific-type-of-array
        // https://howtodoinjava.com/java/collections/arraylist/convert-arraylist-to-array/

        String[] strings = {"qadir","ahmed", "bilal"};
        Stream<String> stringStream = Stream.of(strings);
        strings = stringStream.map((String e) -> {
            return e+" is good guy";
        }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).toArray(String[]::new);
        System.out.println(Arrays.toString(strings));




        Integer[] integers = {12, 32, 123, 432, 923, 129, 37 ,1, 38, 18};
        Integer integer = Arrays.stream(integers).min(Integer::compareTo).get();
        System.out.println(integer);





    }



}
