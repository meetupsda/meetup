package com.sda.meetup.service;

import com.sda.meetup.component.DateTimeEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DateTimeEntryService {

    private List<DateTimeEntry> userEntries = new ArrayList<>();

    void addDateTimeEntry (DateTimeEntry dateTimeEntry) {
               userEntries.add(dateTimeEntry);
    };

   public  void removeDateTimeEntry (DateTimeEntry dateTimeEntry){
        userEntries.remove(dateTimeEntry);
    };

   public void changeDateTimeEntry (){

    };
}
