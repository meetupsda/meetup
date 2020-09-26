package com.sda.meetup.engine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    public static void main(String[] args) {

        LocalDateTime start1 = LocalDateTime.of(
                LocalDate.of(2020, 05, 06),
                LocalTime.of(11, 30));

        LocalDateTime end1 = LocalDateTime.of(
                LocalDate.of(2020, 05, 06),
                LocalTime.of(15, 30));

        LocalDateTime start2 = LocalDateTime.of(
                LocalDate.of(2020, 05, 06),
                LocalTime.of(11, 30));

        LocalDateTime end2 = LocalDateTime.of(
                LocalDate.of(2020, 05, 06),
                LocalTime.of(15, 30));

        LocalDateTime start3 = LocalDateTime.of(
                LocalDate.of(2020, 05, 30),
                LocalTime.of(11, 00));

        LocalDateTime end3 = LocalDateTime.of(
                LocalDate.of(2020, 05, 30),
                LocalTime.of(15, 30));

        LocalDateTime start4 = LocalDateTime.of(
                LocalDate.of(2020, 05, 30),
                LocalTime.of(10, 30));

        LocalDateTime end4 = LocalDateTime.of(
                LocalDate.of(2020, 05, 30),
                LocalTime.of(17, 30));

        LocalDateTime start5 = LocalDateTime.of(
                LocalDate.of(2020, 05, 30),
                LocalTime.of(16, 30));

        LocalDateTime end5 = LocalDateTime.of(
                LocalDate.of(2020, 05, 30),
                LocalTime.of(19, 00));

        Person p1 = new Person(1, start1, end1);
        Person p2 = new Person(2, start2, end2);
        Person p3 = new Person(3, start3, end3);
        Person p4 = new Person(4, start4, end4);
        Person p5 = new Person(5, start5, end5);

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);

        int counter = 0;
        int max = 0;
        LocalDate finalDate = LocalDate.of(2020, 01, 01);

        for (int i = 0; i < persons.size(); i++) {
            LocalDate date1 = persons.get(i).getStart().toLocalDate();

            for (int j = 1; j < persons.size(); j++) {
                LocalDate date2 = persons.get(j).getStart().toLocalDate();
                if (date1.equals(date2)) {
                    counter = counter + 1;
                    if (counter > max) {
                        max = counter;
                        finalDate = date1;
                    }
                } else {
                    counter = 0;
                }
            }
        }

        System.out.println("Najbardziej odpowiedni dzień na spotkanie to " + finalDate);

        System.out.println("Może się spotkać osób: " + max);

        List<Entry> entries = new ArrayList<>();


        for (int i = 0; i < persons.size(); i++) {
            LocalDate date = persons.get(i).getStart().toLocalDate();
            if (date.equals(finalDate)){
                LocalTime StartTime = persons.get(i).getStart().toLocalTime();
                LocalTime EndTime = persons.get(i).getEnd().toLocalTime();
                Entry entry = new Entry(StartTime, EndTime);
                entries.add(entry);
            }
        }

        for (Entry e : entries){
            System.out.println(e);
        }

    }
}
