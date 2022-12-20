package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.CarType;
import com.nhnacademy.gw1.domain.User;
import com.nhnacademy.gw1.exception.LargeCarEnterException;
import com.nhnacademy.gw1.exception.UnregisteredCarException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

public class ParkingLot {
    private final int SPACE_LIMIT = 10;

    private HashMap<String, ParkingSpace> spaces = new HashMap<>(SPACE_LIMIT);


    public ParkingLot() {
        for (int i = 0; i < SPACE_LIMIT; i++) {
            String code = "A1-" + (i + 1);
            spaces.put(code, new ParkingSpace(code));
        }
    }

    public HashMap<String, ParkingSpace> getSpaces() {
        return spaces;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "SPACE_LIMIT=" + SPACE_LIMIT +
                ", spaces=" + spaces +
                '}';
    }

    public LocalDateTime enter(Car car, Entrance entrance) {
        if (car.getCarType() == CarType.LARGE) {
            throw new LargeCarEnterException(car);
        }

        LocalDateTime enteredTime = entrance.scan(car);

        return enteredTime;
    }

    public User exit(Car car, User user, Entrance entrance, Exit exit) {
        if (entrance.getCarEnterTimeList().get(car) == null) {
            throw new UnregisteredCarException(car);
        }

        LocalDateTime carEnterTime = entrance.getCarEnterTimeList().get(car);
        LocalDateTime carExitTime = getExitTime();

        int day = carExitTime.getDayOfMonth() - carEnterTime.getDayOfMonth();
        long totalTime = calcParkingTotalTime(carEnterTime, carExitTime, day);

        User parkedUser = exit.pay(car, user, totalTime, day);

        return parkedUser;
    }

    private long calcParkingTotalTime(LocalDateTime carEnterTime, LocalDateTime carExitTime, int day) {
        if (day > 0) {
            carEnterTime = LocalDateTime.of(carExitTime.getYear(), carExitTime.getMonth(), carExitTime.getDayOfMonth(), 0, 0, 0);
        }

        long enterTime = carEnterTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long exitTime = carExitTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        return exitTime - enterTime;
    }

    public LocalDateTime getExitTime() {
        return LocalDateTime.now();
    }
}
