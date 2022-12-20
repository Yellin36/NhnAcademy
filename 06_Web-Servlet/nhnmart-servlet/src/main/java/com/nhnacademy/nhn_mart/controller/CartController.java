package com.nhnacademy.nhn_mart.controller;

import com.nhnacademy.nhn_mart.Basket;
import com.nhnacademy.nhn_mart.BuyList;
import com.nhnacademy.nhn_mart.FoodStand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

public class CartController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        FoodStand foodStand = (FoodStand) req.getServletContext().getAttribute("foodStand");
        String[] productNames = req.getServletContext().getInitParameter("productNames").split(",");

        BuyList buyList = new BuyList();
        for(int i=0; i< productNames.length; i++) {
            if(req.getParameter(productNames[i]) == "" || req.getParameter(productNames[i]) == null) continue;
            String foodName = productNames[i];
            int foodAmount = Integer.parseInt(req.getParameter(productNames[i]));

            buyList.add(new BuyList.Item(foodName, foodAmount));        //구매 목록에 추가
            int foodStock = foodStand.getFoods().stream()               //재고 현황
                    .filter(x -> x.getName().equals(foodName))
                    .collect(Collectors.toList()).size();
            if(foodStock < foodAmount) {                                //재고 부족
                return "redirect:/foods.do?error=OVERSTOCK";
            }
        }
        System.out.println("5");
        Basket basket = (Basket) req.getServletContext().getAttribute("basket");
        for(BuyList.Item item : buyList.getItems()) {                   //장바구니에 담기
            foodStand.getFoods().stream()
                    .filter(x -> x.getName().equals(item.getName()))
                    .limit(item.getAmount())
                    .collect(Collectors.toList())
                    .forEach(x -> {
                        basket.add(x);
                        foodStand.getFoods().remove(x);
                    });
        }
        req.getServletContext().setAttribute("foodStand", foodStand);
        req.getServletContext().setAttribute("basket", basket);     //장바구니 전달
        return "/cart.jsp";
    }
}
