package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.storage.WaterBill;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface ResultReport {
    Collection<WaterBill> report(Collection<WaterBill> data);
}
