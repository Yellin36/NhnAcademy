package org.example.yerin.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class StandardTest {
    @BeforeAll  // 테스트 클래스 시작 시 한 번
    static void initAll() {
        System.out.println("initAll");
    }

    @BeforeEach
        // 테스트 메서드 시작 시 한 번
    void init() {
        System.out.println("init");
    }

    @Test
    void succeedingTest() {
        System.out.println("succeedingTest");
    }

    @Test
    void failingTest() {
        System.out.println("failingTest");
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes") // 테스트 무시
    void skippedTest() {
        System.out.println("skippedTest");
        // not executed
    }

    @Test
    void abortedTest() {
        System.out.println("abortedTest");
        assumeTrue("abc".contains("Z"));    // 만족 못하면 중지
        fail("test should have been aborted");
    }

    @AfterEach
        // 테스트 메서드 종료 시 한 번
    void tearDown() {
        System.out.println("tearDown");
    }

    @AfterAll   // 테스트 클래스 종료 시 한 번
    static void tearDownAll() {
        System.out.println("tearDownAll");
    }
}