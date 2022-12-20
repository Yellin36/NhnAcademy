package com.nhnacademy.edu.springframework.project.storage;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public interface BillStorage {
    void csvFileLoad(String path) throws IOException;
    void jsonFileLoad(String path) throws IOException;
    Collection<WaterBill> findWaterBillByUsage(int usage);
}
