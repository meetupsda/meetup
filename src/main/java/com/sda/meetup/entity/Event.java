package com.sda.meetup.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Event {

    private Long id;
    private String description;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date2;

    public Event(Long id, String description, LocalDateTime date, LocalDateTime date2) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.date2 = date2;
    }

    public Event() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate2() {
        return date2;
    }

    public void setDate2(LocalDateTime date2) {
        this.date2 = date2;
    }
}
