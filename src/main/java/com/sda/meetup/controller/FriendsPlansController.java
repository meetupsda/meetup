package com.sda.meetup.controller;

import com.sda.meetup.service.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/friends-plans")
public class FriendsPlansController {

    private final EventServiceImpl eventServiceImpl;

    public FriendsPlansController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @RequestMapping
    ModelAndView calendarPage() {
        ModelAndView mnv = new ModelAndView("friends-plans");
        mnv.addObject("events", eventServiceImpl.getAllEvents());
        return mnv;
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView checkMeetingTime() {
        ModelAndView mnv = new ModelAndView("meeting-time");
        mnv.addObject("events", eventServiceImpl.getAllEvents());
        mnv.addObject("bestDate", eventServiceImpl.findBestDate());
        mnv.addObject("bestTime", eventServiceImpl.findBestTime(eventServiceImpl.findBestDate()));
        return mnv;
    }

}
