package com.nhnacademy.springboot.department.parser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class TextParserTest {
    @Autowired
    TextParser parser;

    @Test
    void parsing_failByNotExistFile_thenThrowNullPointerException() {
        String pathName = "none";

        assertThatThrownBy(() -> parser.parsing(pathName))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void parsing_success() {
        String pathName = "src/test/resources/department.txt";

        List<ParsedData> result = parser.parsing(pathName);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(6);
    }
}