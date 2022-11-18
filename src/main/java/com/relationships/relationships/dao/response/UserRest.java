package com.relationships.relationships.dao.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserRest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressesRest> addresses;
}
 