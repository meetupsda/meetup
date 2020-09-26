package com.sda.meetup.engine;

import java.time.LocalTime;

public class Entry {
    LocalTime startTime;
    LocalTime endTime;

    public Entry(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
