package com.sda.meetup.dto;

import com.sda.meetup.entity.Event;
import com.sda.meetup.entity.User;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@ToString
public class EventDTO {

    private Long id;
    private String description;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id"))
    private User user;

    public EventDTO(Long id, String description, LocalDateTime date, LocalDateTime date2, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
