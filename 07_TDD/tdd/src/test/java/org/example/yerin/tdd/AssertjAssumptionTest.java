package org.example.yerin.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class AssertjAssumptionTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnCiServer() {
        assumeThat(System.getenv("ENV")).isEqualTo("CI");
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeThat(System.getenv("ENV"))
                .overridingErrorMessage(() -> "Aborting test: Not on developer server")
                .isEqualTo("DEV");
    }

    @Test
    void testInAllEnvironments() {
        assumeThat(System.getenv("PATH"))
                .overridingErrorMessage(() -> "PATH is empty")
                .isNotEmpty();
        assertThat(calculator.multiply(6, 7)).isEqualTo(42);
    }
}
