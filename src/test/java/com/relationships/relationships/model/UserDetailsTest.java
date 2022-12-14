package com.relationships.relationships.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.relationships.relationships.dao.request.UserLoginRequestModel;
import com.relationships.relationships.dto.AddressDto;
import com.relationships.relationships.dto.UserDto;
import com.relationships.relationships.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserDetailsTest {
    @Autowired
    private UserService userService;
    private UserDto userDto;

    @BeforeEach
    void setUp() throws UnirestException {
        UserDto userDetailsRequestModel = new UserDto();
        List<AddressDto> addresses = new ArrayList<>();
        userDetailsRequestModel.setFirstName("Ololade");
        userDetailsRequestModel.setLastName("Oluwatosin");
        userDetailsRequestModel.setEmail("desuyi@gmail.com");
        userDetailsRequestModel.setPassword("12345");
        userDetailsRequestModel.setAddresses(addresses);
         userDto = userService.createUser(userDetailsRequestModel);
    }

    @AfterEach
    void tearDown() {
        userService.deleteAll();
    }

    @Test
    public void userCanBeCreated() throws UnirestException {
        List<AddressDto> addresses = List.of();
        UserDto userDetailsRequestModel = new UserDto();
        userDetailsRequestModel.setFirstName("Ololade");
        userDetailsRequestModel.setLastName("Oluwatosin");
        userDetailsRequestModel.setEmail("desuyi@gmail.com");
        userDetailsRequestModel.setPassword("12345");
       userDetailsRequestModel.setAddresses(addresses);
        UserDto userDto = userService.createUser(userDetailsRequestModel);
        assertEquals("desuyi@gmail.com", userDto.getEmail());
    }

    @Test
    public void findUserByEmail() {
      UserEntity user =   userService.findByEmail(userDto.getEmail());
        assertEquals("desuyi@gmail.com", user.getEmail());
    }

    @Test
    public void findUserById() {
        UserEntity user = userService.findById(userDto.getId());
        assertThat(user.getId()).isEqualTo(userDto.getId());

    }
    @Test
    public void UserCanLogin() {
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel();
        userLoginRequestModel.setPassword(userDto.getPassword());
        userLoginRequestModel.setEmail(userDto.getEmail());
        userService.login(userLoginRequestModel);
    }
}