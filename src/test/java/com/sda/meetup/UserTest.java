package com.sda.meetup;

import com.sda.meetup.entity.UserEntity;
import com.sda.meetup.repository.EventRepository;
import com.sda.meetup.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserTest {

    @Autowired
    private MockMvc mvc;


    @Autowired
    private UserRepository userRepository;


    @Test
    void shouldFindUserByEmail() throws Exception {
        UserEntity user = new UserEntity("Marianna", "Krakowski", "mkrakow@gmail.com", "Osa0uuRetdry");
        userRepository.save(user);
        Assert.assertNotNull(userRepository.findByEmail("mkrakow@gmail.com"));
    }
}
