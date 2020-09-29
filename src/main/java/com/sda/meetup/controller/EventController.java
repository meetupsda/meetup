package com.sda.meetup.controller;

import com.sda.meetup.dto.EventDto;
import com.sda.meetup.entity.EventEntity;
import com.sda.meetup.service.EventService;
import com.sda.meetup.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventServiceImpl eventService;
/*    @Autowired
    private EventService eventService;*/


    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) {
        model.addAttribute("event", new EventEntity());
        return "new_event";
    }
/*     @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") EventDto event) {
        eventService.saveEvent(event);
        return "saved";
    }*/

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") EventDto event) {
        eventService.saveEvent(event);
        return "saved";
    }

    @GetMapping("/personal-calendar")
    public String viewAllEvents(Model model) {
        /*model.addAttribute("listEvents", eventService.getAllEvents());*/
        model.addAttribute("listEvents", eventService.getEventsByUserId());
        return "personal-calendar";

    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable(value = "id") long id) {
        eventService.deleteEventById(id);
        return "redirect:/personal-calendar";
    }




}
