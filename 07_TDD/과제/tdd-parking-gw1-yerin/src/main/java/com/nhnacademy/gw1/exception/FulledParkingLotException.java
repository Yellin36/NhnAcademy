package com.nhnacademy.gw1.exception;

import com.nhnacademy.gw1.parking.ParkingLot;

public class FulledParkingLotException extends RuntimeException {
    public FulledParkingLotException(ParkingLot parkingLot) {
        super("Fulled Parking Lot : " + parkingLot);
    }
}
