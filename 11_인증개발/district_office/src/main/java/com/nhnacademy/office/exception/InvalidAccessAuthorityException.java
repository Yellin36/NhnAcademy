package com.nhnacademy.office.exception;

import com.nhnacademy.office.entity.BirthDeathReportResident;
import com.nhnacademy.office.entity.Resident;

public class InvalidAccessAuthorityException extends RuntimeException {
    public InvalidAccessAuthorityException(BirthDeathReportResident.Pk pk, Long reportResidentSerialNumber) {
        super(new StringBuilder()
                .append("Invalid Access Authority ( Target Resident : ")
                .append(pk.getResidentSerialNumber())
                .append(", Report Code : ")
                .append(pk.getBirthDeathTypeCode())
                .append(" ) by Resident ")
                .append(reportResidentSerialNumber)
                .toString());
    }
}
