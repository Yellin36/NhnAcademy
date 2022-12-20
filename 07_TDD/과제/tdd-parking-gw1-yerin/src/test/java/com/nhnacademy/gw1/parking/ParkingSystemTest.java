package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.CarType;
import com.nhnacademy.gw1.domain.Money;
import com.nhnacademy.gw1.domain.User;
import com.nhnacademy.gw1.exception.FulledParkingLotException;
import com.nhnacademy.gw1.exception.LargeCarEnterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class ParkingSystemTest {

    ParkingSystem parkingSystem;

    ParkingLot parkingLot = mock(ParkingLot.class);

    @BeforeEach
    void setUp() {
        parkingSystem = new ParkingSystem();
    }


    @Test
    void service_invalidInput_thenThrowInvalidInputException() {
        assertThatThrownBy(() -> parkingSystem.service(null, null, 1000))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContainingAll("Invalid Input");
    }

    @Test
    void service_largeCar_cannotEnter_thenThrowLargeCarException() throws Exception {
        Car car = new Car("k7483BN", CarType.LARGE);
        User user = new User("user@1", new Money(50000));
        long parkingTimeMillis = 3600 * 1000;

        assertThatThrownBy(() -> parkingSystem.service(car, user, parkingTimeMillis))
                .isInstanceOf(LargeCarEnterException.class)
                .hasMessageContainingAll("Large Car", car.toString());
    }

    @ParameterizedTest
    @EnumSource(value = CarType.class, names = "LARGE", mode = EnumSource.Mode.EXCLUDE)
    void service_fulledParkingSpace_thenThrowFulledParkingLotException(CarType carType) throws Exception {
        Car car = new Car("k7483BN", carType);
        User user = new User("user@1", new Money(50000));
        long parkingTimeMillis = 3600 * 1000;

        Collection<ParkingSpace> parkingSpaces = parkingSystem.getParkingLot().getSpaces().values();
        for (ParkingSpace parkingSpace : parkingSpaces) {
            parkingSpace.parkCar(car);
        }

        assertThatThrownBy(() -> parkingSystem.service(car, user, parkingTimeMillis))
                .isInstanceOf(FulledParkingLotException.class)
                .hasMessageContainingAll("Fulled Parking Lot", parkingSystem.getParkingLot().toString());
    }

    @Test
    void service_parkingSystemSuccess() throws Exception {
        Money money = new Money(50000);
        User user = new User("user@1", money);
        long parkingTimeMillis = 3600 * 1000;

        Car mediumCar = new Car("D3732NC", CarType.MEDIUM);

        User result = parkingSystem.service(mediumCar, user, parkingTimeMillis);

        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(User.class);
    }
}