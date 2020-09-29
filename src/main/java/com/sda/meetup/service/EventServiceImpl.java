package com.sda.meetup.service;

import com.sda.meetup.dto.EventDto;
import com.sda.meetup.entity.EventEntity;
import com.sda.meetup.entity.UserEntity;
import com.sda.meetup.repository.EventRepository;
import com.sda.meetup.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {
    /*    private List<Event> userEvents = new ArrayList<>();*/


    private final EventRepository eventRepository;
    private final UserRepository userRepository;


    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

//    public EventServiceImpl(EventRepository eventRepository) {
//        this.eventRepository = eventRepository;
//    }


 /*   @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }*/

    @Override
    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void saveEvent(EventDto event) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername());

        EventEntity eventEntity = event.toEntity(userEntity.getId());
        this.eventRepository.save(eventEntity);

    }

    @Override
    public void deleteEventById(long id) {
        this.eventRepository.deleteById(id);
    }

/*    @Override
    public EventEntity getEventById(long id) {
        Optional<EventEntity> optional = eventRepository.findById(id);
        EventEntity eventEntity = null;
        if (optional.isPresent()) {
            eventEntity = optional.get();
        } else {
            throw new RuntimeException("Event not found for id ::" + id);
        }
        return eventEntity;
    }*/

    public EventEntity getEventById(long idEvent) {
        return eventRepository
                .findById(idEvent)
                .map(event -> new EventEntity(event.getId(), event.getDescription(), event.getDate(), event.getDate2()))
                .orElseThrow(() -> new RuntimeException("Event not found for id ::" + idEvent));
    }


    @Override
    public Set<EventEntity> getEventsByUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername());
        return userEntity.getEvents();
    }
}


