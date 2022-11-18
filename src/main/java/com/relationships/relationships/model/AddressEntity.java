package com.relationships.relationships.model;

import com.relationships.relationships.dto.UserDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class AddressEntity implements Serializable
{
    @Id
//    @Generated(value = "1")
    private String id;
    private String addressId;
    private String city;
    private String country;
    private String streetName;
    private String postalCode;
    private String type;
//    private UserEntity userDetails;
    @DBRef
    private UserEntity userDetails;
}
