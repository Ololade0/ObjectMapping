package com.relationships.relationships.controller;

import com.relationships.relationships.dao.request.UserDetailsRequestModel;
import com.relationships.relationships.dao.response.UserRest;
import com.relationships.relationships.dto.UserDto;
import com.relationships.relationships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/users")
public class controllers {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
//            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) throws Exception {
        UserRest returnValue = new UserRest();
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userDetailsRequestModel, UserDto.class);
        UserDto createdUser = userService.createUser(userDto);

        returnValue = modelMapper.map(createdUser, UserRest.class);
        return returnValue;


    }
    @GetMapping
    public String get() {
        return "Ololade was called";

    }




    @GetMapping("{id}")
    public ResponseEntity<?> findBankById(@PathVariable String id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);

//        }
    }

}



