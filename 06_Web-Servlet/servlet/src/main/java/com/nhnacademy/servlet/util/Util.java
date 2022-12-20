package com.nhnacademy.servlet.util;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class Util {
    static public int increaseCount(ServletContext context) {
        int contextCount = Optional.ofNullable((Integer) context.getAttribute("count")).orElse(0);
        context.setAttribute("count", ++contextCount);
        return contextCount;
    }
    public static Cookie getCookie(HttpServletRequest req, String name) {
        return Optional.ofNullable(req.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(c -> c.getName().equals(name))
                        .findFirst())
                .orElse(null);
    }
}
