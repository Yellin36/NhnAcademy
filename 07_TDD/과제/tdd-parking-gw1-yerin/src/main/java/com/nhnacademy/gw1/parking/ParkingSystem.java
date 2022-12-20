package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.User;
import com.nhnacademy.gw1.exception.FulledParkingLotException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ParkingSystem {
    private final ParkingLot parkingLot;
    private List<Entrance> entrances;
    private List<Exit> exits;

    public ParkingSystem() {
        parkingLot = new ParkingLot();
        entrances = new ArrayList<>(3) {{
            add(new Entrance("GATE1"));
            add(new Entrance("GATE2"));
            add(new Entrance("GATE3"));
        }};

        exits = new ArrayList<>(3) {{
            add(new Exit("GATE1"));
            add(new Exit("GATE2"));
            add(new Exit("GATE3"));
        }};
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public User service(Car car, User user, long parkingTime) throws InterruptedException {
        checkInvalidParameters(user, car);

        Entrance entrance = getNearestEntranceGate();
        LocalDateTime enterTime = parkingLot.enter(car, entrance);

        String parkedSpace = findParkingSpace(car);

        //Thread.sleep(parkingTime);

        Car outCar = takeOutCar(parkedSpace, car);

        Exit exit = getNearestExitGate();
        parkingLot.exit(outCar, user, entrance, exit);

        return user;
    }

    private Car takeOutCar(String parkedSpace, Car car) {
        ParkingSpace parkingSpace = parkingLot.getSpaces().get(parkedSpace);

        Car takeOutCar = parkingSpace.exitCar(car);

        return takeOutCar;
    }

    private void checkInvalidParameters(User user, Car car) {
        if (user == null || car == null) {
            throw new InvalidInputException();
        }
    }


    private String findParkingSpace(Car car) {
        String parkedSpace = null;

        HashMap<String, ParkingSpace> parkingSpaces = parkingLot.getSpaces();
        for (ParkingSpace parkingSpace : parkingSpaces.values()) {
            if (parkingSpace.hasParkingSpace()) {
                parkedSpace = parkingSpace.parkCar(car);
                break;
            }
        }
        checkParkingSpaceIsFull(parkedSpace);

        return parkedSpace;
    }

    private void checkParkingSpaceIsFull(String parkedSpace) {
        if (parkedSpace == null) {
            throw new FulledParkingLotException(parkingLot);
        }
    }

    private Exit getNearestExitGate() {
        Random random = new Random();

        int exitNumber = random.nextInt(exits.size());

        return exits.get(exitNumber);
    }

    private Entrance getNearestEntranceGate() {
        Random random = new Random();

        int entranceNumber = random.nextInt(entrances.size());

        return entrances.get(entranceNumber);
    }
}
