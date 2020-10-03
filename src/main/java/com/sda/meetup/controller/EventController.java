package com.sda.meetup.controller;

import com.sda.meetup.service.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/personal-calendar")
public class EventController {

    private final EventServiceImpl eventServiceImpl;

    public EventController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @RequestMapping
    ModelAndView calendarPage() {
        ModelAndView mnv = new ModelAndView("personal-calendar");
        mnv.addObject("events", eventServiceImpl.getUserEvents());
        return mnv;
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView checkMeetingTime() {
        ModelAndView mnv = new ModelAndView("meeting-time");
        mnv.addObject("events", eventServiceImpl.getUserEvents());
        return mnv;
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable(value = "id") long id) {
        eventServiceImpl.deleteEventById(id);
        return "redirect:/personal-calendar";
    }

}
