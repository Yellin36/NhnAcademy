package com.nhnacademy.gw1.domain;

import java.util.Objects;

public class Car {
    private final String number;
    private final CarType carType;

    public Car(String number, CarType carType) {
        this.number = number;
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", carType=" + carType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(number, car.number) && carType == car.carType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, carType);
    }
}
