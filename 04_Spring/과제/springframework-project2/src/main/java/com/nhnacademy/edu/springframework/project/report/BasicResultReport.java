package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.storage.WaterBill;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Component
public class BasicResultReport implements ResultReport {
    private int printMaxCount = 5;
    @Override
    public Collection<WaterBill> report(Collection<WaterBill> data) {
        Collection<WaterBill> sortedData = data.stream()
                .sorted(Comparator.comparing(WaterBill::getUnitPrice))
                .limit(printMaxCount)
                .collect(Collectors.toList());

        sortedData.stream().forEach(System.out::print);

        return sortedData;
    }
}
