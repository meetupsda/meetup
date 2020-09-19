package com.sda.meetup.controller;

import com.sda.meetup.component.DateTimeEntry;
import com.sda.meetup.service.DateTimeEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/enterdatetime")
public class DateTimeController {

    private final DateTimeEntry dateTimeEntry;

    public DateTimeController(DateTimeEntry dateTimeEntry) {
        this.dateTimeEntry = dateTimeEntry;
    }

    @RequestMapping
    ModelAndView ProposeDateTimePage() {
        ModelAndView mnv = new ModelAndView("dateTimeEntry");
        //TODO dodać obiekt??
        return mnv;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    String addNewProduct(NewProductDTO productDTO) {
//        DateTimeEntryService.addDateTimeEntry(dateTimeEntry);
//        return "redirect:/products";
//    }
}
