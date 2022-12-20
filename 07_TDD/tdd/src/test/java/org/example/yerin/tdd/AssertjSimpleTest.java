package org.example.yerin.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AssertjSimpleTest {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jordan", "Jeong");

    @Test
    void standardAssertions() {
        assertThat(calculator.add(1, 1)).isEqualTo(2);
        assertThat(calculator.multiply(2, 2))
                .as("어설션 라벨")
                .overridingErrorMessage("실패 시 메시지")
                .isEqualTo(4);
        assertThat('a' < 'b')
                .overridingErrorMessage(() -> "실패 시 지연 로딩 메시지")
                .isTrue();
    }

    @Test
    void groupedAssertions() {
        assertThat(person).extracting(Person::getFirstName, Person::getLastName)
                .containsExactly("Jordan", "Jeong");
    }

    @Test
    void dependentAssertions() {
        assertThat(person.getFirstName()).startsWith("J")
                .endsWith("n");
        assertThat(person.getLastName()).startsWith("J")
                .endsWith("g");
    }

    @Test
    void exceptionTesting() {
        assertThatThrownBy(() -> calculator.divide(1, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero");
    }
}

