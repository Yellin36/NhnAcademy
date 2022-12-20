package com.nhnacademy.nhn_mart.controller;

import com.nhnacademy.nhn_mart.Basket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req.getServletContext().getAttribute("totalPrice"));
        System.out.println(req.getServletContext().getAttribute("money"));
        int totalPrice = Integer.parseInt(String.valueOf(req.getServletContext().getAttribute("totalPrice")));
        int paidMoney = Integer.parseInt(String.valueOf(req.getServletContext().getAttribute("money")));
        System.out.println(totalPrice + " " + paidMoney);
        int change = paidMoney - totalPrice;
        if(change >= 0) {
            req.getServletContext().setAttribute("money", change);

            req.getServletContext().setAttribute("totalPrice", 0);
            req.getServletContext().setAttribute("basket", new Basket());
            req.getServletContext().setAttribute("error", "false");

            return "/pay.jsp";
        }
        req.getServletContext().setAttribute("error", "true");
        return "/error.jsp";
    }
}
