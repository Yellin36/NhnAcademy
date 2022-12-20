package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.exception.InvalidCarExitException;

public class ParkingSpace {
    private final String code;
    private Car car;

    public ParkingSpace(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Car getCar() {
        return this.car;
    }

    public boolean hasParkingSpace() {
        return this.car == null;
    }

    public String parkCar(Car car) {
        this.car = car;
        return this.code;
    }

    public Car exitCar(Car car) {
        if (!this.car.equals(car)) {
            throw new InvalidCarExitException(car);
        }
        this.car = null;
        return car;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "code='" + code + '\'' +
                ", car=" + car +
                '}';
    }
}
