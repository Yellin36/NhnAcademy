package com.nhnacademy.edu.servlet.project;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Customer {
    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;
    private int budget = 20_000;
    private int totalPrice;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // 식품을 담는다.
    public void pickFoods(FoodStand foodStand) {
        ArrayList<Food> foods = foodStand.getFoods();

        for(BuyList.Item item : buyList.getItems()) {
            int cnt = 0;

            for(int i=0; i<foods.size(); i++) {
                if(item.getName().equals(foods.get(i).getName())) {
                    basket.add(foods.get(i));
                    foods.remove(i--);
                    cnt++;
                }
                if(item.getAmount() == cnt) break;
            }
            if(item.getAmount() != cnt)
                throw new NoSuchElementException("재고가 부족합니다.");
        }
    }
    public void payTox(Counter counter) {
        budget = counter.checkout(budget, basket);
    }
}
