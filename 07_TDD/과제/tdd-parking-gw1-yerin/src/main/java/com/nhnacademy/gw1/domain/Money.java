package com.nhnacademy.gw1.domain;

public class Money {
    private long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return this.amount;
    }

    public Money subtract(Money parkingFee) {
        long remainingAmount = this.amount -= parkingFee.getAmount();

        return new Money(remainingAmount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
