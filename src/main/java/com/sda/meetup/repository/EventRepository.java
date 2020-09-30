package com.sda.meetup.repository;

import com.sda.meetup.dto.EventDTO;
import com.sda.meetup.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event save(EventDTO eventDTO);
}
