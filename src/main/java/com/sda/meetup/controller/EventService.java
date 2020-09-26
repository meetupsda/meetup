package com.sda.meetup.controller;

import com.sda.meetup.entity.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private List<Event> userEvents = new ArrayList<>();

    public void addDateTimeEntry (Event event) {userEvents.add(event);
    };

    public void removeDateTimeEntry (Event event){
        userEvents.remove(event);
    };
}
