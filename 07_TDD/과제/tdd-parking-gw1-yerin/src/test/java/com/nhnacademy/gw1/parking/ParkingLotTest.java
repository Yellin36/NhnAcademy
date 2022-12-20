package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.CarType;
import com.nhnacademy.gw1.domain.Money;
import com.nhnacademy.gw1.domain.User;
import com.nhnacademy.gw1.exception.LargeCarEnterException;
import com.nhnacademy.gw1.exception.UnregisteredCarException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParkingLotTest {
    ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot();
    }

    @Test
    void enterCarFailure_largeCarEnter_thenThrowLargeCarEnterException() {
        Car car = new Car("K3825DJ", CarType.LARGE);
        Entrance entrance = new Entrance("GATE1");

        assertThatThrownBy(() -> parkingLot.enter(car, entrance))
                .isInstanceOf(LargeCarEnterException.class)
                .hasMessageContainingAll("Large Car Enter", car.toString());
    }

    @ParameterizedTest
    @EnumSource(value = CarType.class, names = "LARGE", mode = EnumSource.Mode.EXCLUDE)
    void enterCarSuccess(CarType carType) {
        Car car = new Car("K3825DJ", carType);
        Entrance entrance = new Entrance("GATE1");

        LocalDateTime result = parkingLot.enter(car, entrance);

        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(LocalDateTime.class);
    }

    @Test
    void exitCarFailure_unregisteredCar_thenThrowUnregisteredCarException() {
        Car car = new Car("S6549MD", CarType.MEDIUM);
        User user = new User("user@1", new Money(20000));

        Entrance entrance = new Entrance("GATE1");
        Exit exit = new Exit("EXIT1");

        assertThatThrownBy(() -> parkingLot.exit(car, user, entrance, exit))
                .isInstanceOf(UnregisteredCarException.class)
                .hasMessageContainingAll("Unregistered Car", car.toString());
    }

    @Test
    void exitCarSuccess() {
        Car car = new Car("S4849MD", CarType.MEDIUM);
        User user = new User("user@1", new Money(20000));

        Entrance entrance = new Entrance("GATE1");
        Exit exit = new Exit("EXIT1");

        entrance.scan(car);

        User result = parkingLot.exit(car, user, entrance, exit);

        assertThat(result).isNotNull();
        assertThat(result.getUserId()).isEqualTo(user.getUserId());
    }


}