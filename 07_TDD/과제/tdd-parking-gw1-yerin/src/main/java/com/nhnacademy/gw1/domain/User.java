package com.nhnacademy.gw1.domain;

import com.nhnacademy.gw1.exception.LackOfMoneyException;

public class User {
    private final String userId;
    private Money money;

    public User(String userId, Money money) {
        this.userId = userId;
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public Money getMoney() {
        return money;
    }


    public Money pay(Money parkingFee) {
        if (this.money.getAmount() < parkingFee.getAmount()) {
            throw new LackOfMoneyException(money);
        }
        this.money = this.money.subtract(parkingFee);

        return this.money;
    }
}
