package com.sda.meetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/friends-plans")
public class FriendsPlansController {

    private final EventService eventService;

    public FriendsPlansController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping
    ModelAndView calendarPage() {
        ModelAndView mnv = new ModelAndView("friends-plans");
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
