package com.sda.meetup.service;

import com.sda.meetup.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getEventsByUserId();
}
