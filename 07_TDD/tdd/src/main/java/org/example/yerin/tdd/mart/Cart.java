package org.example.yerin.tdd.mart;

import java.util.*;

public class Cart {
    private int LIST_LIMIT = 10;
    private int capacity = 0;
    private List<Goods> goodsList = new ArrayList<>(10);
    public void addItem(Goods something) {
        this.capacity++;
        if(isOver()) {
            this.capacity--;
            throw new cartCapacityOverException();
        }
        goodsList.add(something);
    }
    public boolean isOver() {
        return capacity > 10;
    }
    public List<Goods> getAllItem() {
        return Collections.unmodifiableList(goodsList);
    }
}
