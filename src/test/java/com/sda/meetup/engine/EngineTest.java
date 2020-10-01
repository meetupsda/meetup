package com.sda.meetup.engine;

import com.sda.meetup.entity.Event;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    LocalDateTime start1 = LocalDateTime.of(
            LocalDate.of(2020, 05, 06),
            LocalTime.of(11, 30));

    LocalDateTime end1 = LocalDateTime.of(
            LocalDate.of(2020, 05, 06),
            LocalTime.of(15, 30));

    LocalDateTime start2 = LocalDateTime.of(
            LocalDate.of(2020, 05, 06),
            LocalTime.of(11, 30));

    LocalDateTime end2 = LocalDateTime.of(
            LocalDate.of(2020, 05, 06),
            LocalTime.of(15, 30));

    LocalDateTime start3 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(11, 00));

    LocalDateTime end3 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(15, 30));

    LocalDateTime start4 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(10, 30));

    LocalDateTime end4 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(17, 30));

    LocalDateTime start5 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(16, 30));

    LocalDateTime end5 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(19, 00));

    LocalDateTime start6 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(12, 30));

    LocalDateTime end6 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(20, 00));

    LocalDateTime start7 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(14, 30));

    LocalDateTime end7 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(17, 00));

    LocalDateTime start8 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(15, 45));

    LocalDateTime end8 = LocalDateTime.of(
            LocalDate.of(2020, 05, 30),
            LocalTime.of(17, 15));

    Event e1 = new Event(Long.valueOf(1), "a", start1, end1);
    Event e2 = new Event(Long.valueOf(2), "b", start2, end2);
    Event e3 = new Event(Long.valueOf(3), "c", start3, end3);
    Event e4 = new Event(Long.valueOf(4), "d", start4, end4);
    Event e5 = new Event(Long.valueOf(5), "e", start5, end5);
    Event e6 = new Event(Long.valueOf(6), "e", start6, end6);
    Event e7 = new Event(Long.valueOf(7), "e", start7, end7);
    Event e8 = new Event(Long.valueOf(8), "e", start8, end8);

    List<Event> events = List.of(e6, e7, e8);


    @Test
    void shouldReturnequalDates() {

        //given
        List<Event> events = List.of(e1, e2);

        //when
        LocalDate bestEventDate = Engine.findBestDate(events);

        //then
        assertNotNull(bestEventDate);
        assertEquals(bestEventDate, LocalDate.of(2020, 05, 06));
    }

//            System.out.println(findBestDate(events));
//
//        System.out.println(findBestTime(events, findBestDate(events)));
//
//        System.out.println(findMinTime(start1.toLocalTime(), start3.toLocalTime()));
//
//        System.out.println(findMaxTime(start1.toLocalTime(), start3.toLocalTime()));
//
//        System.out.println(findOverlap(e1, e3));
//
//        System.out.println(findOverlap(e4, e5));
//
//        System.out.println(findBestTime(events, findBestDate(events)));
}