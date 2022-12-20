package com.nhnacademy.edu.springframework.project.storage;

import java.util.List;

public class Segment {
    private int num;
    private int level;
    private List<Integer> startSegments;
    private List<Integer> endSegments;
    private List<Integer> unitPrices;

    public Segment(int num, int level, List<Integer> startSegments, List<Integer> endSegments, List<Integer> unitPrices) {
        this.num = num;
        this.level = level;
        this.startSegments = startSegments;
        this.endSegments = endSegments;
        this.unitPrices = unitPrices;
    }

    public int getNum() {
        return num;
    }

    public int getLevel() {
        return level;
    }

    public List<Integer> getStartSegments() {
        return startSegments;
    }

    public List<Integer> getEndSegments() {
        return endSegments;
    }

    public List<Integer> getUnitPrices() {
        return unitPrices;
    }
    public int getUnitPrice(int usage) {
        for (int i=0; i<level; i++) {
            if(endSegments.get(i) > usage) {
                return unitPrices.get(i);
            }
        }
        return 0;
    }
}
