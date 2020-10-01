package com.sda.meetup.controller;

import com.sda.meetup.dto.EventDTO;
import com.sda.meetup.entity.Event;
import com.sda.meetup.service.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddEventController {

    private final EventServiceImpl eventServiceImpl;

    public AddEventController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @GetMapping("/add-event")
    public String addEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "add-event";
    }

    @PostMapping("/add-event")
    public String savedEvent(EventDTO eventDTO, Model model) {
        model.addAttribute("event", eventDTO);
        eventServiceImpl.saveEvent(eventDTO);
        return "saved";
    }
}
