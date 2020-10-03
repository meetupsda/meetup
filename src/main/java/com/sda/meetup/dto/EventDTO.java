package com.sda.meetup.dto;

import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@ToString
public class EventDTO {

    private Long id;
    @NotEmpty(message = "This field can not be empty !")
    private String description;

    @FutureOrPresent(message = "Please add present or future date.")
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date;

    @Future(message = "Please add future date.")
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date2;
    private UserDTO user;

    public EventDTO(Long id, String description, LocalDateTime date, LocalDateTime date2, UserDTO user) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.date2 = date2;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public EventDTO() {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
