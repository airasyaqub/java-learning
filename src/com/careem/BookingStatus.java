package com.careem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public enum BookingStatus {
    CANCELLED(4),
    TRIP_ENDED(2),
    TRIP_COMPLETED(8);

    private final Integer statusCode;

    private static final Map<Object, Object> map = new HashMap<>();

    BookingStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }


    static {
        for (BookingStatus bookingStatus : BookingStatus.values()) {
            map.put(bookingStatus.statusCode, bookingStatus);
        }
    }

    public static BookingStatus valueOf(int statusCode) {
        return (BookingStatus) map.get(statusCode);
    }
}


