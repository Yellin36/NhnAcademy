package com.nhnacademy.gw1.exception;

import com.nhnacademy.gw1.domain.Money;

public class LackOfMoneyException extends RuntimeException {
    public LackOfMoneyException(Money money) {
        super("Lack Of Money : " + money);
    }
}
