package com.careem;


public class EnumDemo {

    public static void main(String[] args)  {

        int bookingStatusResponse = 4;

        System.out.println(BookingStatus.valueOf(bookingStatusResponse) == BookingStatus.CANCELLED);

    }
}
