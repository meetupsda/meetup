package com.sda.meetup.controller;

import com.sda.meetup.service.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventServiceImpl eventServiceImpl;

    public EventController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @GetMapping("/personal-calendar")
    public String viewAllEvents(Model model) {
        /*model.addAttribute("listEvents", eventService.getAllEvents());*/
        model.addAttribute("events", eventServiceImpl.getUserEvents());
        return "personal-calendar";

    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable(value = "id") long id) {
        eventServiceImpl.deleteEventById(id);
        return "redirect:/personal-calendar";
    }



}
