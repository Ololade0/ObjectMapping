package com.relationships.relationships.dto;

import com.relationships.relationships.model.AddressEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@ToString
public class UserDto implements Serializable {
    private static final long serialVersionUid = 1L;
    private String id;
    private String userId;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String encryptedPassword;
    private  String emailVerification;
    private  Boolean emailVerificationStatus = false;
    private List<AddressDto>  addresses;
;


}

