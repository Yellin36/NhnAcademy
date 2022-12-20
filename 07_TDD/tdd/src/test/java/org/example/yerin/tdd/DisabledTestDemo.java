package org.example.yerin.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
        System.out.println("testWillBeSkipped");
    }
}

class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
        System.out.println("testWillBeSkipped");
    }

    @Test
    void testWillBeExecuted() {
        System.out.println("testWillBeExecuted");
    }
}
