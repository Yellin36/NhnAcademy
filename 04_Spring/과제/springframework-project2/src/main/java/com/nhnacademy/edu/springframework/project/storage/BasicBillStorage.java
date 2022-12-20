package com.nhnacademy.edu.springframework.project.storage;

import com.nhnacademy.edu.springframework.project.parser.Data;
import com.nhnacademy.edu.springframework.project.parser.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BasicBillStorage implements BillStorage {
    private Collection<WaterBill> waterBills;
    private Collection<Segment> segments;
    private DataParser csvDataParser;
    private DataParser jsonDataParser;

    @Autowired
    public BasicBillStorage(DataParser csvDataParser, DataParser jsonDataParser) {
        this.csvDataParser = csvDataParser;
        this.jsonDataParser = jsonDataParser;
    }

    @Override
    public void csvFileLoad(String path) throws IOException {
        Collection<Data> parsedData = parsedData = this.csvDataParser.parse(path);

        waterBills = new ArrayList<>();
        segments = new ArrayList<>();

        int cnt = 0;
        int num = 1;
        List<Integer> startSegment = new ArrayList<>();
        List<Integer> endSegment = new ArrayList<>();
        List<Integer> unitPrice = new ArrayList<>();
        for (Data data : parsedData) {
            if(data.getLevel() == 1) {
                waterBills.add(new WaterBill(num, data.getCity(), data.getSector()));
                if(cnt != 0) segments.add(new Segment((num - 1), cnt, startSegment, endSegment, unitPrice));

                startSegment = new ArrayList<>();
                endSegment = new ArrayList<>();
                unitPrice = new ArrayList<>();
                cnt = 0;
                num++;
            }
            startSegment.add(data.getStartSegment());
            endSegment.add(data.getEndSegment());
            unitPrice.add(data.getUnitPrice());
            cnt++;
        }
        segments.add(new Segment(num - 1, cnt, startSegment, endSegment, unitPrice));
    }

    @Override
    public void jsonFileLoad(String path) throws IOException {
        Collection<Data> parsedData = this.jsonDataParser.parse(path);

        waterBills = new ArrayList<>();
        segments = new ArrayList<>();

        int cnt = 0;
        int num = 1;
        List<Integer> startSegment = new ArrayList<>();
        List<Integer> endSegment = new ArrayList<>();
        List<Integer> unitPrice = new ArrayList<>();
        for (Data data : parsedData) {
            if(data.getLevel() == 1) {
                waterBills.add(new WaterBill(num, data.getCity(), data.getSector()));
                if(cnt != 0) segments.add(new Segment((num - 1), cnt, startSegment, endSegment, unitPrice));

                startSegment = new ArrayList<>();
                endSegment = new ArrayList<>();
                unitPrice = new ArrayList<>();
                cnt = 0;
                num++;
            }
            startSegment.add(data.getStartSegment());
            endSegment.add(data.getEndSegment());
            unitPrice.add(data.getUnitPrice());
            cnt++;
        }
        segments.add(new Segment(num - 1, cnt, startSegment, endSegment, unitPrice));
    }

    @Override
    public Collection<WaterBill> findWaterBillByUsage(int usage) {
        if(usage <= 0) throw new IllegalArgumentException("잘못된 사용량입니다.");

        for (WaterBill waterBill : waterBills) {
            for(Segment segment : segments) {
                if(segment.getNum() == waterBill.getNum()) {
                    waterBill.setUnitPrice(segment.getUnitPrice(usage));
                    waterBill.setBillTotal(usage);

                    break;
                }
            }
        }
        return waterBills;
    }
}
