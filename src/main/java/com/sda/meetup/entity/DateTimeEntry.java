package com.sda.meetup.entity;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//@Entity
@NoArgsConstructor
public class DateTimeEntry {

private String username;
private String event;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private Date date;
        @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private Date date2;

    public DateTimeEntry(String username, String event, Date date, Date date2) {
        this.username = username;
        this.event = event;
        this.date = date;
        this.date2 = date2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate2() {
        return date2;
    }
}
