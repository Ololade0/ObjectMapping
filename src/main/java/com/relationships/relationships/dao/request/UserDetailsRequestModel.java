package com.relationships.relationships.dao.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDetailsRequestModel {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
   private List<AddressRequestModel> addresses;
}
