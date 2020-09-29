package com.sda.meetup.service;

import com.sda.meetup.dto.EventDto;
import com.sda.meetup.entity.EventEntity;
import java.util.List;
import java.util.Set;

public interface EventService {

    List<EventEntity> getAllEvents();
    void saveEvent(EventDto event);
    void deleteEventById(long id);
    EventEntity getEventById(long id);
    Set<EventEntity> getEventsByUserId();
}
