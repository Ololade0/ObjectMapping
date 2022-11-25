package com.relationships.relationships.dto;

import com.relationships.relationships.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDto {
    private String id;
    private String addressId;
    private String city;
    private String country;
    private String streetName;
    private String postalCode;
    private String type;
//    private UserDto userDetails;

}
