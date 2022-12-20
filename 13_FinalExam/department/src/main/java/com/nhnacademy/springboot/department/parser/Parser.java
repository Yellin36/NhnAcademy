package com.nhnacademy.springboot.department.parser;

import java.util.List;

public interface Parser {
    List<ParsedData> parsing(String fileName);
}
