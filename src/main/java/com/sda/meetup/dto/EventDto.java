package com.sda.meetup.dto;

import com.sda.meetup.entity.EventEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class EventDto {

    @NotEmpty(message = "This field can not be empty.")
    private String description;


    @NotEmpty(message = "This field can not be empty.")
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date;

    @NotEmpty(message = "This field can not be empty.")
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date2;

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

    public EventEntity toEntity(Long userId) {

        return new EventEntity(this.description, this.date, this.date2, userId);

    }
}
