package com.sda.meetup.controller;

import com.sda.meetup.entity.EventEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal-calendar")
public class PersonalCalendarController {

        @GetMapping
        public String main(Model model) {
            model.addAttribute("event", new EventEntity());
            return "personal-calendar";
        }

        @PostMapping
        public String save(EventEntity event, Model model) {
            model.addAttribute("event", event);
            return "saved";
        }

}
