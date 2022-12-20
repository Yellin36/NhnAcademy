package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.config.JavaConfig;
import com.nhnacademy.edu.springframework.project.storage.BillStorage;
import com.nhnacademy.edu.springframework.project.storage.WaterBill;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JavaConfig.class})
public class WaterUsageBillServiceTest {

    @Autowired
    WaterUsageBillService waterUsageBillService;

    @Autowired
    BillStorage billStorage;
    @BeforeEach
    void setData() throws Exception{
        String path = "src/test/resources/data/Tariff_20220331.csv";
        billStorage.csvFileLoad(path);
    }

    @Test
    @DisplayName("calculateBill 성공")
    void calculateBill() {
        int usage = 1000;

        Collection<WaterBill> result = waterUsageBillService.calculateBill(usage);

        Assertions.assertThat(result.stream().filter(x -> x.getBillTotal() != 0)).hasSize(18);
    }
    @Test
    @DisplayName("calculateBill 실패: 사용량을 받아줄 업체가 없는 경우")
    void calculateBillFailedByOverUsage() {
        int overUsage = 1000000000;

        Collection<WaterBill> result = waterUsageBillService.calculateBill(overUsage);

        Assertions.assertThat(result).hasSize(0);
    }

    @Test
    @DisplayName("calculateBill 실패: 잘못된 사용량")
    void calculateBillFailedByWrongUsage() {
        int overUsage = 0;

        Assertions.assertThatThrownBy(()
                -> waterUsageBillService.calculateBill(overUsage)).isInstanceOf(IllegalArgumentException.class);
    }
}