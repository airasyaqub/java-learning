package com.careem;

import java.util.ArrayList;
import java.util.LinkedList;

class ArrList {


    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(5);
        arrayList.add(0);
        arrayList.add(20);
        arrayList.add(0);

        ArrList.zerosToStart(arrayList);

    }




    public static void zerosToStart(ArrayList<Integer> arrList) {
        //write your code here

        for (int i = 0; i < arrList.size(); i++ ) {

            System.out.println(arrList.get(i) + " " + i);

            System.out.println(arrList.get(i) == 0 && i!=0);

            if (arrList.get(i) == 0 && i!=0) {

                for (int j = i; j > 0; j--) {

                    System.out.println("j value ==> " + j);
                    System.out.println("at index j value ==> " + arrList.get(j-1));

                    System.out.println(arrList.get(j-1)!= 0);

                    if ( arrList.get(j-1)!= 0 ) {

                        int temp = arrList.get(j-1);
                        arrList.set(j-1, arrList.get(j));
                        arrList.set(j, temp);

                        System.out.println(arrList);

                    } else {

                        break;

                    }
                }

            }


        }


        System.out.println(arrList);


    }
}