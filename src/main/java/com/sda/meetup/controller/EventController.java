package com.sda.meetup.controller;

import com.sda.meetup.entity.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/addevent")
    public String addEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "add-event";
    }

    @PostMapping("/addevent")
    public String savedEvent(Event event, Model model) {
        model.addAttribute("event", event);
        return "saved";
    }
}
