package com.nhnacademy.office.exception;

import com.nhnacademy.office.entity.BirthDeathReportResident;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlreadyRegisteredExceptionTest {
    @Test
    void test() {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(1L, "출생");
        Exception exception = new AlreadyRegisteredException(BirthDeathReportResident.class, pk);

        System.out.println(exception.getMessage());
    }

}