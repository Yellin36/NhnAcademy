package com.nhnacademy.edu.springframework.project.parser;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

@Component
public class CsvDataParser implements DataParser {

    @Override
    public Collection<Data> parse(String filepath) throws IOException {
        Collection<Data> parsingData = new ArrayList<>();

        File csvFile = new File(filepath);
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            String line = "";
            while((line = br.readLine()) != null) {
                String[] words = line.split(",");

                int num = Integer.valueOf(words[0]);
                String city = words[1].trim();
                String sector = words[2].trim();
                int level = Integer.valueOf(words[3]);
                int startSegment = Integer.valueOf(words[4]);
                int endSegment = Integer.valueOf(words[5]);
                int unitBill = Integer.valueOf(words[6]);

                parsingData.add(new Data(num, city, sector, level, startSegment, endSegment, unitBill));
            }
        } catch (FileNotFoundException e) {
            throw new NoSuchElementException("해당파일이 존재하지 않습니다.");
        }
        return parsingData;
    }
}
