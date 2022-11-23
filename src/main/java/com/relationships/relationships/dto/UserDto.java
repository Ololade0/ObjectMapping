package com.relationships.relationships.dto;

import com.relationships.relationships.model.AddressEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
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
    @NotNull(message = "firstname cannot be null")
    private  String firstName;

    @NotNull(message = "lastname cannot be null")
    private  String lastName;

    @NotNull(message = "email cannot be null")
    private  String email;


    @NotNull(message = "password cannot be null")
    private  String password;

    private  String emailVerification;
    private  Boolean emailVerificationStatus = false;
    private List<AddressDto>  addresses;
;


}

