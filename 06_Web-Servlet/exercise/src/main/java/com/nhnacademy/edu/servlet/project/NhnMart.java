package com.nhnacademy.edu.servlet.project;

import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        Customer jordan = new Customer(buyList);
        // 장바구니를 챙긴다.
        jordan.bring(mart.provideBasket());
        // 식품을 담는다.
        jordan.pickFoods(mart.getFoodStand());
        // 카운터에서 계산한다.
        jordan.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        System.out.print("> ");

        String line = scanner.nextLine();
        String[] lists = line.split(" ");

        int productAmount;
        String productName = "";

        BuyList buyList = new BuyList();
        for (int i = 0; i < lists.length; i++) {
            if(i % 2 == 0) productName = lists[i];
            else {
                productAmount = Integer.valueOf(lists[i]);
                buyList.add(new BuyList.Item(productName, productAmount));
            }
        }
        return buyList;
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();
    private final Counter counter = new Counter();
    public Counter getCounter() {
        return this.counter;
    }

    public FoodStand getFoodStand() {
        prepareMart();
        return this.foodStand;
    }

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }
}
