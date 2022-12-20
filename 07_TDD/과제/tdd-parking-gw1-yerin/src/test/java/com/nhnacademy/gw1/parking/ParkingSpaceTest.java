package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.CarType;
import com.nhnacademy.gw1.exception.InvalidCarExitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParkingSpaceTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("R2394KL", CarType.LARGE);
    }

    @Test
    void space_checkFalse_hasParkingSpace() {
        ParkingSpace parkingSpace = new ParkingSpace("A1-1");

        assertThat(parkingSpace.hasParkingSpace()).isTrue();
    }

    @Test
    void space_checkTrue_hasParkingSpace() {
        ParkingSpace parkingSpace = new ParkingSpace("A1-1");
        parkingSpace.parkCar(car);

        assertThat(parkingSpace.hasParkingSpace()).isFalse();
    }
    @Test
    void space_parkCarSuccess() {
        ParkingSpace emptyParkingSpace = new ParkingSpace("A1-1");

        String parkingSpace = emptyParkingSpace.parkCar(car);

        assertThat(parkingSpace).isNotNull();
        assertThat(parkingSpace).isEqualTo(emptyParkingSpace.getCode());
    }

    @Test
    void space_exitCarFailure_invalidCar_thenThrowInvalidCarExitException() {
        ParkingSpace fulledParkingSpace = new ParkingSpace("A1-1");
        Car exitCar = new Car("K7493IH", CarType.MEDIUM);

        fulledParkingSpace.parkCar(car);

        assertThatThrownBy(() -> fulledParkingSpace.exitCar(exitCar))
                .isInstanceOf(InvalidCarExitException.class)
                .hasMessageContainingAll("Invalid Car Exit", exitCar.toString());
    }

    @Test
    void space_exitCarSuccess() {
        ParkingSpace fulledParkingSpace = new ParkingSpace("A1-1");

        fulledParkingSpace.parkCar(car);

        Car exitCar = fulledParkingSpace.exitCar(car);

        assertThat(exitCar).isNotNull();
        assertThat(exitCar).isEqualTo(car);
    }
}