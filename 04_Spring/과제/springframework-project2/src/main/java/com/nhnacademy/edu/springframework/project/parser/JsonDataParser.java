package com.nhnacademy.edu.springframework.project.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@Component
public class JsonDataParser implements DataParser {
    @Override
    public Collection<Data> parse(String filepath) throws IOException {
        Collection<Data> parsingData;
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filepath);

        String line = "";
        String lines = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while((line = reader.readLine()) != null)
                lines += line + "\n";
        } catch (FileNotFoundException e) {
            throw new NoSuchElementException();
        }
        parsingData = Arrays.asList(mapper.readValue(lines, Data[].class));

        return parsingData;
    }
}
