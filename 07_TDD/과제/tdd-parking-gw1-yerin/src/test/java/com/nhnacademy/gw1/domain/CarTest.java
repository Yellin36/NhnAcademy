package com.nhnacademy.gw1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void car_checkEqualFailure_differentNumber() {
        Car car1 = new Car("D9484LK", CarType.LARGE);
        Car car2 = new Car("D9284LK", CarType.LARGE);

        assertThat(car1).isNotEqualTo(car2);
    }

    @Test
    void car_checkEqualFailure_differentType() {
        Car car1 = new Car("D9484LK", CarType.LARGE);
        Car car2 = new Car("D9484LK", CarType.LIGHT);

        assertThat(car1).isNotEqualTo(car2);
    }

    @Test
    void car_checkEqualFailure_differentCar() {
        Car car1 = new Car("D9484LK", CarType.LARGE);
        Car car2 = new Car("D3254LK", CarType.MEDIUM);

        assertThat(car1).isNotEqualTo(car2);
    }

    @Test
    void car_checkEqual() {
        Car car1 = new Car("D9484LK", CarType.LARGE);
        Car car2 = new Car("D9484LK", CarType.LARGE);

        assertThat(car1).isEqualTo(car2);
    }
}