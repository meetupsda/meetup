package com.sda.meetup.controller;

import com.sda.meetup.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    public final UserServiceImpl userServiceImpl;

    public ProfileController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping
    ModelAndView profilePage() {
        ModelAndView mnv = new ModelAndView("profile");
        mnv.addObject("user", userServiceImpl.getUserProfile());
        return mnv;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    ModelAndView profilePage() {
//        ModelAndView mnv = new ModelAndView("profile");
//        mnv.addObject("user", userServiceImpl.getUserById());
//        return mnv;
//    }

}
