package com.sda.meetup.component;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DateTimeEntry {

private String username; //TODO do zmiany na User
private LocalDate date;
private LocalTime time;
//TODO dodać enum available/unavailable?
    //TODO dodać event?

    public DateTimeEntry(String username, LocalDate date, LocalTime time) {
        this.username = username;
        this.date = date;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
