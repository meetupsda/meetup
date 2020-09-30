package com.sda.meetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/personal-calendar")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping
    ModelAndView calendarPage() {
        ModelAndView mnv = new ModelAndView("personal-calendar");
        mnv.addObject("events", eventService.getUserEvents());
        return mnv;
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView checkMeetingTime() {
        ModelAndView mnv = new ModelAndView("meeting-time");
        mnv.addObject("events", eventService.getUserEvents());
        mnv.addObject("checkTimes", eventService.findSuitableDate());
        return mnv;
    }

}
