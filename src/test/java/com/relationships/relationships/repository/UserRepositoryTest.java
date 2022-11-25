package com.relationships.relationships.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail() {
        System.out.println(userRepository.findByEmail("adesuyiololade@gmail.com"));
        assertThat(userRepository.findByEmail("adesuyiololade@gmail.com")).isNotNull();
    }
}