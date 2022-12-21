//package com.relationships.relationships.controller;
//
//import com.relationships.relationships.dto.UserDto;
//import com.relationships.relationships.exception.UserCannotBeFoundExcepttion;
//import com.relationships.relationships.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/user")
//public class controllers {
//    @Autowired
//    private UserService userService;
//
//   @PostMapping("/register")
//    public ResponseEntity<?> createUser(@RequestBody UserDto userDetailsRequestModel) throws Exception {
//        try {
//            UserDto userDto = userService.createUser(userDetailsRequestModel);
//            return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
//        } catch (UserCannotBeFoundExcepttion e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//    @GetMapping
//    public String get() {
//        return "Ololade was called";
//
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<?> findBankById(@PathVariable String id){
//        return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
//
//    }
//
//}
//
//
//
