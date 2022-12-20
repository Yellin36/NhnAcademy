package com.nhnacademy.edu.springframework.project.parser;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public interface DataParser {
    public Collection<Data> parse(String filepath) throws IOException;
}
