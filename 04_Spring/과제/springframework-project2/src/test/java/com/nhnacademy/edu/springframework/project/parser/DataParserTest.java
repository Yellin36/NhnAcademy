package com.nhnacademy.edu.springframework.project.parser;

import com.nhnacademy.edu.springframework.project.config.JavaConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.NoSuchElementException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JavaConfig.class})
public class DataParserTest {
    @Autowired
    public DataParser jsonDataParser;
    @Autowired
    public DataParser csvDataParser;

    @Test
    @DisplayName("json parse 성공: 올바른 파일")
    void jsonParse() throws Exception {
        String path = "src/test/resources/data/Tariff_20220331.json";

        Collection<Data> result = jsonDataParser.parse(path);

        Assertions.assertThat(result).hasSize(49);
    }

    @Test
    @DisplayName("json parse 실패: 없는 파일 입력")
    public void jsonParseFiledByPath() {
        String path = "wrong/path/non-existed-file.json";

        Assertions.assertThatThrownBy(() -> jsonDataParser.parse(path))
                .isInstanceOf(NoSuchElementException.class);
    }
    @Test
    @DisplayName("csv parse 성공: 올바른 파일")
    void csvParse() throws Exception {
        String path = "src/test/resources/data/Tariff_20220331.csv";

        Collection<Data> result = csvDataParser.parse(path);

        Assertions.assertThat(result).hasSize(50);
    }

    @Test
    @DisplayName("csv parse 실패: 없는 파일 입력")
    public void csvParseFiledByPath() {
        String path = "wrong/path/non-existed-file.csv";

        Assertions.assertThatThrownBy(() -> csvDataParser.parse(path))
                .isInstanceOf(NoSuchElementException.class);
    }
}
