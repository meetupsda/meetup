package com.sda.meetup.service;

import com.sda.meetup.dto.RegistrationDto;
import com.sda.meetup.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;
import java.math.BigInteger;


public interface UserService extends UserDetailsService{

    User findByEmail(String email);

    User save(@Valid RegistrationDto registration);
}

