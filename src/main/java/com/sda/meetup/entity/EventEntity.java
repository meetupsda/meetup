package com.sda.meetup.entity;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTS")
@AllArgsConstructor
public class EventEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String description;


    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date;


    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date2;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Long userId;

    public EventEntity(String description, LocalDateTime date, LocalDateTime date2, Long userId) {
        this.description = description;
        this.date = date;
        this.date2 = date2;
        this.userId = userId;
    }

    public EventEntity() {
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

    public EventEntity(Long id, String description, LocalDateTime date, LocalDateTime date2) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.date2 = date2;
    }
}



