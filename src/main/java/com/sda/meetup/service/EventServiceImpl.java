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

@Service
public class EventServiceImpl implements EventService{
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


/*    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }*/

    @Override
    public void saveEvent(EventDto event) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername());

        EventEntity eventEntity = event.toEntity(userEntity.getId());
        this.eventRepository.save(eventEntity);

    }

}
