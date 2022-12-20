package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.CarType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class EntranceTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("가38492나", CarType.LARGE);
    }

    @ParameterizedTest
    @EnumSource(value = CarType.class, names = "LARGE", mode = EnumSource.Mode.EXCLUDE)
    void scanCarSuccess(CarType carType) {
        Entrance entrance = new Entrance("GATE1");

        String carNumber = "R3349KL";
        Car car = new Car(carNumber, carType);

        LocalDateTime result = entrance.scan(car);

        assertThat(entrance.getCarEnterTimeList().get(car)).isNotNull();
        assertThat(result).isInstanceOf(LocalDateTime.class);
    }

}