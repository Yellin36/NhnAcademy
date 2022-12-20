package com.nhnacademy.nhn_mart.controller;

import com.nhnacademy.nhn_mart.Basket;
import com.nhnacademy.nhn_mart.Food;
import com.nhnacademy.nhn_mart.FoodStand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String[] productNames = req.getServletContext().getInitParameter("productNames").split(",");
        String[] productPrices = req.getServletContext().getInitParameter("productPrices").split(",");
        String[] productAmounts = req.getServletContext().getInitParameter("productAmounts").split(",");

        FoodStand foodStand = new FoodStand();
        for(int i=0; i<productNames.length; i++) {
            int productAmount = Integer.parseInt(productAmounts[i]);

            for (int j = 0; j < productAmount; j++) {
                foodStand.add(new Food(productNames[i], Integer.parseInt(productPrices[i])));
            }
        }
        req.getServletContext().setAttribute("foodStand", foodStand);
        req.getServletContext().setAttribute("foodNames", productNames);
        req.getServletContext().setAttribute("foodPrices", productPrices);
        req.getServletContext().setAttribute("money", 20000);
        req.getServletContext().setAttribute("basket", new Basket());
        req.getServletContext().setAttribute("totalPrice", 0);
        return "/init.jsp";
    }
}
