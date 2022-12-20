package com.nhnacademy.edu.springframework.project.storage;

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
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JavaConfig.class})
public class BillStorageTest {
    @Autowired
    BillStorage billStorage;


    @Test
    @DisplayName("csvFileLoad 성공")
    void csvFileLoad() throws Exception {
        String path = "src/test/resources/data/Tariff_20220331.csv";

        billStorage.csvFileLoad(path);

        Collection<WaterBill> resultData = billStorage.findWaterBillByUsage(100);

        Assertions.assertThat(resultData).hasSize(18);
    }
    @Test
    @DisplayName("csvFileLoad 실패: 잘못된 경로 입력")
    void csvFileLoadFailedByWrongPath() throws Exception{
        String path = "wrong/path/non-existed-file.csv";

        Assertions.assertThatThrownBy(() -> billStorage.csvFileLoad(path))
                .isInstanceOf(NoSuchElementException.class);

    }
    @Test
    @DisplayName("jsonFileLoad 성공")
    void jsonFileLoad() throws Exception {
        String path = "src/test/resources/data/Tariff_20220331.json";

        billStorage.jsonFileLoad(path);

        Collection<WaterBill> resultData = billStorage.findWaterBillByUsage(100);

        Assertions.assertThat(resultData).hasSize(18);
    }
    @Test
    @DisplayName("jsonFileLoad 실패: 잘못된 경로 입력")
    void jsonFileLoadFailedByWrongPath() throws Exception{
        String path = "wrong/path/non-existed-file.json";

        Assertions.assertThatThrownBy(() -> billStorage.jsonFileLoad(path))
                .isInstanceOf(NoSuchElementException.class);

    }
    @Test
    @DisplayName("findWaterBillByUsage 성공")
    void findWaterBillByUsage() {
        Collection<WaterBill> result = billStorage.findWaterBillByUsage(1000);

        Assertions.assertThat(result.stream()
                .filter(x -> x.getBillTotal() != 0)
                .collect(Collectors.toList())).hasSize(18);
    }
    @Test
    @DisplayName("findWaterBillByUsage 실패: 사용량을 받아줄 업체가 없는 경우")
    void findWaterBillByUsageFailedByOverUsage() {
        int overUsage = 1000000000;

        Collection<WaterBill> result = billStorage.findWaterBillByUsage(overUsage);

        Assertions.assertThat(result.stream().filter(x -> x.getBillTotal() == 0)).hasSize(18);
    }

    @Test
    @DisplayName("findWaterBillByUsage 실패: 잘못된 사용량")
    void findWaterBillByUsageFailedByWrongUsage() {
        int overUsage = 0;

        Assertions.assertThatThrownBy(()
                -> billStorage.findWaterBillByUsage(overUsage)).isInstanceOf(IllegalArgumentException.class);
    }
}