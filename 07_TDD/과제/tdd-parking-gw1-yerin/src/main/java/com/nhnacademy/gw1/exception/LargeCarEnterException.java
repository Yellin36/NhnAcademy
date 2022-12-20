package com.nhnacademy.gw1.exception;

import com.nhnacademy.gw1.domain.Car;

public class LargeCarEnterException extends RuntimeException {
    public LargeCarEnterException(Car car) {
        super("Large Car Enter : " + car);
    }
}
