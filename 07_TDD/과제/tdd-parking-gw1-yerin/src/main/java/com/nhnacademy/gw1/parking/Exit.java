package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.CarType;
import com.nhnacademy.gw1.domain.Money;
import com.nhnacademy.gw1.domain.User;


public class Exit {
    private final long TEN_MINUTE = 600000;
    private final long THIRTY_MINUTE = 1800000;
    private final long ONE_HOUR = 3600000;

    private final String exitId;

    public Exit(String exitId) {
        this.exitId = exitId;
    }

    public User pay(Car car, User user, long totalTime, int day) {
        Money parkingFee;

        parkingFee = calcParkingFee(totalTime, day);
        parkingFee = discountFee(car, parkingFee);

        user.pay(parkingFee);

        return user;
    }

    private Money discountFee(Car car, Money parkingFee) {
        long discountedFee = parkingFee.getAmount();

        if (car.getCarType() == CarType.LIGHT) {
            discountedFee /= 2;
        }

        return new Money(discountedFee);
    }

    //최초 30분	무료
    //최초 30초과 ~ 1시간	1,000원
    //이 후 추가 10분	500원	1초라도 넘으면 부과됩니다.
    //일일 주차	15,000원	일 최대 금액입니다. 24:00이 넘어가면 추가 요금이 부과됩니다.
    //2일 연속 주차 시 30,000원
    private Money calcParkingFee(long totalTime, int day) {
        long totalFee;

        if (day > 0) {
            totalFee = getDayOverParkingFee(totalTime, day);
            return new Money(totalFee);
        }
        totalFee = getDayParkingFee(totalTime);

        return new Money(totalFee);
    }

    private long getDayOverParkingFee(long totalTime, int day) {
        long totalFee = (totalTime == 0) ? 0 : 15000;

        totalFee += (long) day * 15000;

        return totalFee;
    }

    private long getDayParkingFee(long totalTime) {
        long totalFee;

        if (totalTime <= THIRTY_MINUTE) {
            totalFee = 0;
        } else if (totalTime <= ONE_HOUR) {
            totalFee = 1000;
        } else {
            totalFee = 1000 + (long) Math.ceil((double) (totalTime - ONE_HOUR) / TEN_MINUTE) * 500;
        }
        totalFee = checkMaximumFee(totalFee);

        return totalFee;
    }

    private long checkMaximumFee(long totalFee) {
        return (totalFee > 15000) ? 15000 : totalFee;
    }
}
