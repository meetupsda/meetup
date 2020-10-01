package com.sda.meetup.engine;

import com.sda.meetup.entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Engine {

    public static LocalDate findBestDate(List<Event> events) {

        int counter = 0;
        int max = 0;
        LocalDate bestDate = LocalDate.MIN;
        for (int i = 0; i < events.size(); i++) {
            LocalDate date1 = events.get(i).getDate().toLocalDate();

            for (int j = 1; j < events.size(); j++) {
                LocalDate date2 = events.get(j).getDate().toLocalDate();
                if (date1.equals(date2)) {
                    counter = counter + 1;
                    if (counter > max) {
                        max = counter;
                        bestDate = date1;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return bestDate;
    }

    public static LocalTime findMinTime(LocalTime time1, LocalTime time2) {
        LocalTime min = (time1.isBefore(time2) || time1.equals(time2) ? time1 : time2);
        return min;
    }

    public static LocalTime findMaxTime(LocalTime time1, LocalTime time2) {
        LocalTime max = (time1.isAfter(time2) | time1.equals(time2) ? time1 : time2);
        return max;
    }

    public static Overlap findOverlap(Event event1, Event event2) {
//       TODO set constraints (StartA <= EndA) and (StartB <= EndB)) in the addEvent form

        Overlap overlap = new Overlap(LocalTime.MIN, LocalTime.MAX);

        if ((event1.getDate().toLocalTime().isBefore(event2.getDate2().toLocalTime())
                && event2.getDate().toLocalTime().isBefore(event1.getDate2().toLocalTime()))) {
            overlap.setStartTime(findMaxTime(event1.getDate().toLocalTime(), event2.getDate().toLocalTime()));
            overlap.setEndTime(findMinTime(event1.getDate2().toLocalTime(), event2.getDate2().toLocalTime()));
        }
        return overlap;
    }

    public static Overlap findBestTime(List<Event> events, LocalDate bestDate) {

        Overlap bestTime = new Overlap(LocalTime.MIN, LocalTime.MAX);

        List<Event> eventsOnBestDate = events.stream()
                .filter(a -> a.getDate().toLocalDate().equals(bestDate))
                .collect(Collectors.toList());

        for (int i = 0; i < eventsOnBestDate.size(); i++) {
            Event event1 = eventsOnBestDate.get(i);
            for (int j = 1; j < eventsOnBestDate.size(); j++) {
                Event event2 = eventsOnBestDate.get(j);
                Overlap overlap = findOverlap(event1, event2);
                if (!overlap.equals(bestTime)) {
                    bestTime = Overlap.compare(overlap, bestTime);
                }
            }
        }
        return bestTime;
    }
}



