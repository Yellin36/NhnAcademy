package com.nhnacademy.gw1.exception;

import com.nhnacademy.gw1.domain.Car;

public class UnregisteredCarException extends RuntimeException {
    public UnregisteredCarException(Car car) {
        super("Unregistered Car : " + car);
    }
}
