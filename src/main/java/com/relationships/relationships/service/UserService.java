package com.relationships.relationships.service;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.relationships.relationships.dao.request.UserLoginRequestModel;
import com.relationships.relationships.dao.response.UserLoginResponse;
import com.relationships.relationships.dto.UserDto;
import com.relationships.relationships.model.UserEntity;

import java.util.Optional;

public interface UserService{
    UserDto createUser(UserDto userDetailsRequestModel) throws UnirestException;

    UserEntity findByEmail(String email);

    UserEntity findById(String id);

    UserLoginResponse login(UserLoginRequestModel userLoginRequestModel);

    void deleteAll();
}
