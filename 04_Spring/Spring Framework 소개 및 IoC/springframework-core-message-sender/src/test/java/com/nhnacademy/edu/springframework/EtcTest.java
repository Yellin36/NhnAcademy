package com.nhnacademy.edu.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.UrlResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EtcTest {
    @Test
    void testUrlResource() throws Exception {
        try (InputStream inputStream = new UrlResource("https://www.manty.co.kr").getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    //java -jar app.jar -Dspring.progiles.active=real, us
}
