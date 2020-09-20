package com.sda.meetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
class MainController {

    @RequestMapping
    ModelAndView loginPage() {
        ModelAndView mnv = new ModelAndView("login");
        return mnv;
    }

}