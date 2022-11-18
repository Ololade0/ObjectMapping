package com.relationships.relationships.dao.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressesRest {
    private String id;
    private String addressId;
    private String city;
    private String country;
    private String streetName;
    private String postalCode;
    private String type;
}
