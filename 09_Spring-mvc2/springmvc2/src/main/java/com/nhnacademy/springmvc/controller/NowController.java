package com.nhnacademy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class NowController {
    @GetMapping("/now")
    // = @RequestMapping(value= "/now", method=RequestMethod.GET)
    public String now(Model model) {
        model.addAttribute("now", LocalDateTime.now());

        return "now";
    }

    //최근 트드
    @GetMapping("/now2")
    public String now2(Model model) {
        Current current = new Current(LocalDateTime.now());
        model.addAttribute("current", current);

        return "now2";
    }
    //예전에 썼던 형식
    @GetMapping("/now3")
    public ModelAndView now3(Model model) {
        ModelAndView mav = new ModelAndView("now2");
        Current current = new Current(LocalDateTime.now());

        mav.addObject("current", current);
        return mav;
    }

    public class Current {
        private final LocalDateTime now;

        public Current(LocalDateTime now) {
            this.now = now;
        }

        public LocalDateTime getNow() {
            return now;
        }//요청 헤더 값 가변인자인 경우 required = false 인 경우 default value 잘 사용해보자
    }
}