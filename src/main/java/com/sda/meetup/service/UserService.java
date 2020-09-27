package com.sda.meetup.service;

import com.sda.meetup.dto.RegistrationDto;
import com.sda.meetup.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;


public interface UserService extends UserDetailsService{

    UserEntity findByEmail(String email);

    UserEntity save(@Valid RegistrationDto registration);
}

