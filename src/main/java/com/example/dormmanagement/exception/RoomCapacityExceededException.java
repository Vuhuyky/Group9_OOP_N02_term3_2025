package com.example.dormmanagement.exception;

public class RoomCapacityExceededException extends RuntimeException {
    public RoomCapacityExceededException(String message) {
        super(message);
    }
}
