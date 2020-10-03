package com.sda.meetup;

import java.time.LocalTime;
import java.util.Objects;

import static com.sda.meetup.service.EventServiceImpl.findMaxTime;
import static com.sda.meetup.service.EventServiceImpl.findMinTime;

public class Overlap {

    LocalTime startTime;
    LocalTime endTime;

    public Overlap(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "from " + startTime +
                " to " + endTime;
    }

    public static Overlap compare(Overlap overlap1, Overlap overlap2) {
        Overlap overlap = new Overlap(LocalTime.MIN, LocalTime.MAX);
        if ((overlap1.getStartTime()).isBefore(overlap2.getEndTime())
                && overlap2.getStartTime().isBefore(overlap2.getEndTime())) {
            overlap.setStartTime(findMaxTime(overlap1.getStartTime(), overlap2.getStartTime()));
            overlap.setEndTime(findMinTime(overlap1.getEndTime(), overlap2.getEndTime()));
        }
        return overlap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Overlap overlap = (Overlap) o;
        return Objects.equals(startTime, overlap.startTime) &&
                Objects.equals(endTime, overlap.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }


}
