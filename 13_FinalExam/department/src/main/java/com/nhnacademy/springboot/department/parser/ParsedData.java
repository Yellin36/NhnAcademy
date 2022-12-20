package com.nhnacademy.springboot.department.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParsedData {
    private Long memberId;
    private String memberName;
    private String departmentName;
    private String departmentId;
}
