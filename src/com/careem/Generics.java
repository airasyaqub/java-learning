package com.careem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Generics {



    public static void main(String[] args) {


        Generics generics = new Generics();

        generics.convertName("Airas");


        Generics.rotate(new int[]{55,6,-1,7,100});

    }


    private <T> T convertName(T val) {
        return val;
    }



    public static ArrayList<Integer> separate(ArrayList<Integer> myList) {

        // Enter your code here


        for (int i = 0; i < myList.size(); i++) {


            if (myList.get(i) % 2 == 0) {

                if(i == 0) {
                    continue;
                } else {

                    for (int j = i; j > 0; j--) {

                        if (myList.get(j-1) % 2 != 0){

                            int temp = myList.get(j);

                            myList.set(j, myList.get(j-1));
                            myList.set(j-1, temp);


                        }


                    }


                }

            }


        }

        System.out.println(myList);

        /* You do not need to worry about the return statement for the
        moment and just set the values in “myList” correctly*/
        return myList;
    }



    public static int[] rotate(int[] arr) {



        int[] newArr = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {

            if ( i + 2 <= arr.length-1 ){
                newArr[i + 2] = arr[i];
            } else if (i + 2 > arr.length-1) {
                int diff = (i + 2) - (arr.length-1);
                newArr[diff-1] = arr[i];
            }

        }

        /* You do not need to worry about the return statement for the
        moment and just set the values in “arr” correctly*/
        return newArr;
    }



    private class ConvertToList <T> {

        T elementToPutInList;


        ConvertToList(T elementToPutInList) {
            this.elementToPutInList = elementToPutInList;
        }


        // List<T> or K
        public <K extends List<T>> List<T> addToList(K list) {

            System.out.println(list);

            list.add(elementToPutInList);

            return list;
        }

        public void printElem() {
            System.out.println("my elem is " + elementToPutInList);
        }



    }




}
