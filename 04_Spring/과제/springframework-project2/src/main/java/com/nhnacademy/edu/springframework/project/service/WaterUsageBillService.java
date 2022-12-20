package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.storage.WaterBill;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface WaterUsageBillService {
    Collection<WaterBill> calculateBill(int usage);
}
