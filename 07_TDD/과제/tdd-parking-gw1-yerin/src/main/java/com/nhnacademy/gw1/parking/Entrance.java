package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Entrance {
    private final String entranceId;
    private final static Map<Car, LocalDateTime> carEnterTimeList = new HashMap<>();

    public Entrance(String entranceId) {
        this.entranceId = entranceId;
    }

    public String getEntranceId() {
        return entranceId;
    }

    public Map<Car, LocalDateTime> getCarEnterTimeList() {
        return carEnterTimeList;
    }

    public LocalDateTime scan(Car car) {
        LocalDateTime enterTime = LocalDateTime.now();

        carEnterTimeList.put(car, enterTime);

        return enterTime;
    }
}
