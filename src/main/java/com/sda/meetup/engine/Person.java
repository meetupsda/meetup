package com.sda.meetup.engine;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {

    private Integer id;
    private LocalDateTime start;
    private LocalDateTime end;

    public Person(Integer id, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return start.equals(person.start) &&
                end.equals(person.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
