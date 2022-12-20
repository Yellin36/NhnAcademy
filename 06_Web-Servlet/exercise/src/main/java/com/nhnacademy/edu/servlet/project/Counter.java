package com.nhnacademy.edu.servlet.project;

public class Counter {
    public int checkout(int paidMoney, Basket basket) {
        int totalPrice = 0;

        System.out.println("============================");
        for (Food food : basket.getFoods()) {
            System.out.println("\t + " + food.getName() + ": " + food.getPrice() + "원");
            totalPrice += food.getPrice();
        }
        System.out.println("============================");
        System.out.println("총 가격은 " + totalPrice + "원 입니다.");

        int change = paidMoney - totalPrice;
        if(change < 0) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
        System.out.println("고객님 결제 후 잔액: " + change);
        return change;
    }
}
