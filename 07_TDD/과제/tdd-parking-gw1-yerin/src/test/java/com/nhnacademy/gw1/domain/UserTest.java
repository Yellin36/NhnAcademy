package com.nhnacademy.gw1.domain;

import com.nhnacademy.gw1.exception.LackOfMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    void user_payFailure_noEnoughMoney_thenThrowLackOfMoneyException() {
        String userId = "user@01";
        Money money = new Money(0);
        Money parkingFee = new Money(1000);

        User user = new User(userId, money);

        assertThatThrownBy(() -> user.pay(parkingFee)).isInstanceOf(LackOfMoneyException.class);
    }
    @Test
    void user_paySuccess() {
        String userId = "user@01";
        Money money = new Money(1000);
        Money parkingFee = new Money(1000);

        User user = new User(userId, money);

        assertThat(user.pay(parkingFee).getAmount()).isEqualTo(0);
    }
}