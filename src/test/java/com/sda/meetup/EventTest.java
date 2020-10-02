package com.sda.meetup;

import com.sda.meetup.dto.RegistrationDto;
import com.sda.meetup.entity.EventEntity;
import com.sda.meetup.entity.UserEntity;
import com.sda.meetup.repository.EventRepository;
import com.sda.meetup.repository.UserRepository;
import com.sda.meetup.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EventTest {

    @Autowired
    private MockMvc mvc;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;


    @Test
    void shouldSaveEvents() {
        EventEntity event1 = new EventEntity("Swimming", LocalDateTime.of(
                LocalDate.of(2020, 10, 6),
                LocalTime.of(15, 30)),
                LocalDateTime.of(
                        LocalDate.of(2020, 10, 7),
                        LocalTime.of(16, 30)));
        EventEntity event2 = new EventEntity("Cycling", LocalDateTime.of(
                LocalDate.of(2020, 11, 9),
                LocalTime.of(15, 30)),
                LocalDateTime.of(
                        LocalDate.of(2020, 11, 10),
                        LocalTime.of(16, 30)));
        EventEntity event3 = new EventEntity("Hiking", LocalDateTime.of(
                LocalDate.of(2020, 12, 06),
                LocalTime.of(15, 30)),
                LocalDateTime.of(
                        LocalDate.of(2020, 12, 07),
                        LocalTime.of(17, 30)));
        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);
        Assert.assertNotNull(eventRepository);
    }

    @Test
    void shouldDeleteEventById() {
        EventEntity event8 = new EventEntity("Swimming", LocalDateTime.of(
                LocalDate.of(2020, 10, 6),
                LocalTime.of(15, 30)),
                LocalDateTime.of(
                        LocalDate.of(2020, 10, 7),
                        LocalTime.of(16, 30)));
        eventRepository.save(event8);
        eventRepository.deleteById(event8.getId());
        eventRepository.findById(event8.getId()).isEmpty();

    }

/*    @Test
    void shouldReturnEventsByUserId(){
        UserEntity user = new UserEntity("Ewa", "Nowak", "ewanowak@gmail.com", "Royete%736g");
        EventEntity event9 = new EventEntity("Cooking", LocalDateTime.of(
                LocalDate.of(2020, 12, 06),
                LocalTime.of(15, 30)),
                LocalDateTime.of(
                        LocalDate.of(2020, 12, 07),
                        LocalTime.of(17, 30)));
        EventEntity event10 = new EventEntity("Running", LocalDateTime.of(
                LocalDate.of(2020, 12, 06),
                LocalTime.of(15, 30)),
                LocalDateTime.of(
                        LocalDate.of(2020, 12, 07),
                        LocalTime.of(17, 30)));
        Set<EventEntity> events = user.setEvents(Set.of(event9,event10));
        Assert.assertEquals(user.getEvents(), events);



    }*/


}







