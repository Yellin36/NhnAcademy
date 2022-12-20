package com.nhnacademy.springboot.department.parser;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TextParser implements Parser {
    @Override
    public List<ParsedData> parsing(String pathName) throws NullPointerException{
        File file = new File(pathName);

        List<ParsedData> parsedDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> words = Arrays.stream(line.split("\\|"))
                        .filter(x -> !Objects.equals(x, ""))
                        .map(String::trim)
                        .collect(Collectors.toList());

                if (words.get(0).contains("-") || words.contains("사번")) continue;

                ParsedData parsedData = new ParsedData(
                        Long.parseLong(words.get(0)),
                        words.get(1),
                        words.get(2),
                        words.get(3));
                parsedDataList.add(parsedData);
            }
        } catch (IOException e) {
            throw new NullPointerException();
        }
        return parsedDataList;
    }
}
