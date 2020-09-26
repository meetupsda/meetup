package com.sda.meetup.controller;

import com.sda.meetup.entity.DateTimeEntry;
import com.sda.meetup.service.DateTimeEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DateTimeController {

    private final DateTimeEntryService dateTimeEntryService;

    public DateTimeController(DateTimeEntryService dateTimeEntryService) {
        this.dateTimeEntryService = dateTimeEntryService;
    }

    @GetMapping("/adddate")
    public String submitDateTimeForm(Model model) {
        model.addAttribute("dateTimeEntry", new DateTimeEntry());
        return "addDateTimeEntry";
    }

    @PostMapping ("/adddate")
    public String saveDateTime(DateTimeEntry dateTimeEntry, Model model) {
        model.addAttribute("dateTimeEntry", dateTimeEntry);
        return "savedDateTimeEntry";
    }

}
