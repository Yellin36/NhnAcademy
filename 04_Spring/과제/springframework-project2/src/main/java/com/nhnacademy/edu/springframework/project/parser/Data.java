package com.nhnacademy.edu.springframework.project.parser;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility =  JsonAutoDetect.Visibility.ANY)
public class Data {
    @JsonProperty("순번")
    private int num;
    @JsonProperty("지자체명")
    private String city;
    @JsonProperty("업종")
    private String sector;
    @JsonProperty("단계")
    private int level;
    @JsonProperty("구간시작(세제곱미터)")
    private int startSegment;
    @JsonProperty("구간끝(세제곱미터)")
    private int endSegment;
    @JsonProperty("구간금액(원)")
    private int unitPrice;
    @JsonProperty("단계별 기본요금(원)")
    private String segmentBill;

    public Data() {}
    public Data(int num, String city, String sector, int level, int startSegment, int endSegment, int unitPrice) {
        this.num = num;
        this.city = city;
        this.sector = sector;
        this.level = level;
        this.startSegment = startSegment;
        this.endSegment = endSegment;
        this.unitPrice = unitPrice;
    }

    public Data(int num, String city, String sector, int level, int startSegment, int endSegment, int unitPrice, String segmentBill) {
        this.num = num;
        this.city = city;
        this.sector = sector;
        this.level = level;
        this.startSegment = startSegment;
        this.endSegment = endSegment;
        this.unitPrice = unitPrice;
        this.segmentBill = segmentBill;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getLevel() {
        return level;
    }

    public int getStartSegment() {
        return startSegment;
    }

    public int getEndSegment() {
        return endSegment;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String toString() {
        return "Data { num=" + num + ", "
                + "city=" + city + ", "
                + "sector=" + sector + ", "
                + "level=" + level + ", "
                + "startSegment=" + startSegment + ","
                + "endSegment=" + endSegment + ", "
                + "unitPrice=" + unitPrice + "}";
    }
}

