package com.sda.meetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping
    ModelAndView indexPage() {
        ModelAndView mnv = new ModelAndView("home");
        return mnv;
    }

}

