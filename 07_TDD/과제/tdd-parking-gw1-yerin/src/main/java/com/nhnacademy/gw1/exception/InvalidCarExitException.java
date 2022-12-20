package com.nhnacademy.gw1.exception;

import com.nhnacademy.gw1.domain.Car;

public class InvalidCarExitException extends RuntimeException {
    public InvalidCarExitException(Car car) {
        super("Invalid Car Exit : " + car);
    }
}
