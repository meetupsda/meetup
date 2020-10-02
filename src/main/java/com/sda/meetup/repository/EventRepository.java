package com.sda.meetup.repository;

import com.sda.meetup.dto.EventDto;
import com.sda.meetup.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

}
