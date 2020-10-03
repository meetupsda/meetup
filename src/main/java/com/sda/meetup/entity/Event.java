package com.sda.meetup.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime date2;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id"))
    private Long userId;;

    public Event(String description, LocalDateTime date, LocalDateTime date2, User user) {
        this.description = description;
        this.date = date;
        this.date2 = date2;
        this.userId = user.getId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(description, event.description) &&
                Objects.equals(date, event.date) &&
                Objects.equals(date2, event.date2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, date, date2);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}