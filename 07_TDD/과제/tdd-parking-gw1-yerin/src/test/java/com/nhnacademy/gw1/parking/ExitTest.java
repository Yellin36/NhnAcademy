package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.domain.Car;
import com.nhnacademy.gw1.domain.CarType;
import com.nhnacademy.gw1.domain.Money;
import com.nhnacademy.gw1.domain.User;
import com.nhnacademy.gw1.exception.LackOfMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExitTest {
    Exit exit;

    @BeforeEach
    void setUp() {
        exit = new Exit("EXIT1");
    }

    @Test
    void exit_payFailure_noEnoughMoney_thenThrowLackOfMoneyException() {
        Money money = new Money(0);
        User user = new User("user@1", money);
        Car car = new Car("D3732NC", CarType.MEDIUM);

        assertThatThrownBy(() -> exit.pay(car, user, 0, 1))
                .isInstanceOf(LackOfMoneyException.class)
                .hasMessageContainingAll("Lack Of Money", user.getMoney().toString());
    }

    @ParameterizedTest(name = "case [{3}] -> {2}")
    @CsvFileSource(resources = "/medium_car_test_resource.csv")
    void exitMediumCar_paySuccess(long totalTime, int day, long expectedExchange, String caseName) {
        Money money = new Money(50000);
        User user = new User("user@1", money);

        Car mediumCar = new Car("D3732NC", CarType.MEDIUM);

        User result = exit.pay(mediumCar, user, totalTime, day);

        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(User.class);
        assertThat(result.getMoney().getAmount()).isEqualTo(expectedExchange);
    }

    @ParameterizedTest(name = "case [{3}] -> {2}")
    @CsvFileSource(resources = "/light_car_test_resource.csv")
    void exitLightCar_paySuccess(long totalTime, int day, long expectedExchange, String caseName) {
        Money money = new Money(50000);
        User user = new User("user@1", money);

        Car lightCar = new Car("K3849KD", CarType.LIGHT);
        User result = exit.pay(lightCar, user, totalTime, day);

        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(User.class);
        assertThat(result.getMoney().getAmount()).isEqualTo(expectedExchange);
    }
}