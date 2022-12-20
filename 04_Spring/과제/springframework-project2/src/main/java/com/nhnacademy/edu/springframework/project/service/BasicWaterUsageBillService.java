package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.storage.BillStorage;
import com.nhnacademy.edu.springframework.project.storage.WaterBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class BasicWaterUsageBillService implements WaterUsageBillService {
    private BillStorage billStorage;

    @Autowired
    public BasicWaterUsageBillService(BillStorage billStorage) {
        this.billStorage = billStorage;
    }

    @Override
    public Collection<WaterBill> calculateBill(int usage) {
        Collection<WaterBill> calculatedBill = billStorage.findWaterBillByUsage(usage).stream()
                .filter(x -> x.getBillTotal() != 0)
                .collect(Collectors.toList());

        return calculatedBill;
    }
}
