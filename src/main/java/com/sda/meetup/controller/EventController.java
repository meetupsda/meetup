package com.sda.meetup.controller;

import com.sda.meetup.dto.EventDto;
import com.sda.meetup.entity.EventEntity;
import com.sda.meetup.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) {
        model.addAttribute("event", new EventEntity());
        return "new_event";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") EventDto event) {
        eventService.saveEvent(event);
        return "saved";
    }

}
