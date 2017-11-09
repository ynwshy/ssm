package com.hhfree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {


    @RequestMapping("/helloMAV")
    public ModelAndView helloModelAndView() {
        return new ModelAndView("hello");
    }

    @RequestMapping("/helloString")
    public String helloString() {
        return "hello";
    }
    @RequestMapping("/404")
    public String nopage() {
        return "redirect:/nopage.html";
    }
}
