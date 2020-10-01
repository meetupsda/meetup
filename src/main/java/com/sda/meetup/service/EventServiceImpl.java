package com.sda.meetup.service;

import com.sda.meetup.dto.EventDTO;
import com.sda.meetup.entity.Event;
import com.sda.meetup.entity.User;
import com.sda.meetup.repository.EventRepository;
import com.sda.meetup.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    private List<Event> userEvents = new ArrayList<>();

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public Event saveEvent(EventDTO eventDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User userEntity = userRepository.findByEmail(userDetails.getUsername());

        Event event = new Event();
        event.setDescription(eventDTO.getDescription());
        event.setDate(eventDTO.getDate());
        event.setDate2(eventDTO.getDate2());
        event.setUser(userEntity);
        return eventRepository.save(event);
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(entity -> new EventDTO(entity.getId(), entity.getDescription(), entity.getDate(), entity.getDate2(), entity.getUser()))
                .collect(Collectors.toList());
    }

    public List<Event> getUserEvents(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User userEntity = userRepository.findByEmail(userDetails.getUsername());

        return userEntity.getEvents();
    }

    @Override
    public void deleteEventById(Long id) {
        this.eventRepository.deleteById(id);
    }

    public LocalDate findSuitableDate() {
        int counter = 0;
        int max = 0;
        LocalDate suitableDate = LocalDate.of(2020, 01, 01);

        List<EventDTO> userEvents = eventRepository
                .findAll()
                .stream()
                .map(entity -> new EventDTO(entity.getId(), entity.getDescription(), entity.getDate(), entity.getDate2(), entity.getUser()))
                .collect(Collectors.toList());

        for (int i = 0; i < userEvents.size(); i++) {
            LocalDate date1 = userEvents.get(i).getDate().toLocalDate();

            for (int j = 1; j < userEvents.size(); j++) {
                LocalDate date2 = userEvents.get(j).getDate().toLocalDate();
                if (date1.equals(date2)) {
                    counter = counter + 1;
                    if (counter > max) {
                        max = counter;
                        suitableDate = date1;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return suitableDate;
    }

}