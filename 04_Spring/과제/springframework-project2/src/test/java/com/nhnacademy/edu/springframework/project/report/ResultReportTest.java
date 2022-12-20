package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.config.JavaConfig;
import com.nhnacademy.edu.springframework.project.service.WaterUsageBillService;
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
public class ResultReportTest {
    @Autowired
    BillStorage billStorage;
    @Autowired
    WaterUsageBillService waterUsageBillService;
    @Autowired
    ResultReport resultReport;

    @BeforeEach
    void setData() throws Exception {
        String path = "src/test/resources/data/Tariff_20220331.csv";
        billStorage.csvFileLoad(path);
    }

    @Test
    @DisplayName("report 성공")
    void report() {
        int usage = 1000;
        Collection<WaterBill> data = waterUsageBillService.calculateBill(usage);

        Collection<WaterBill> result = resultReport.report(data);

        int previousBillTotal= 0;
        boolean sortingCheck = true;
        for(WaterBill waterBill : result) {
            if(previousBillTotal == 0) previousBillTotal = waterBill.getBillTotal();
            if(previousBillTotal > waterBill.getBillTotal()) sortingCheck = false;
        }
        Assertions.assertThat(sortingCheck).isTrue();
    }

}
