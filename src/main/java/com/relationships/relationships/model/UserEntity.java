package com.relationships.relationships.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class UserEntity {
    @Id
    private String id;
    private String userId;
    @Pattern(regexp = "^[a-zA-Z0-9]{1,12}$",
            message = "firstName must be of 1 to 12 length with no special characters")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z0-9]{1,12}$",
            message = "lastName must be of 1 to 12 length with no special characters")
    private String lastName;
    private String email;
    private String password;
    private boolean isEnabled;
    @DBRef
    List<AddressEntity> addresses = new ArrayList<>();
    private Set<Role> roles = new HashSet<>();

    public UserEntity(String firstName, String lastName, String email, String password, RoleType roleType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        if (roles == null) {
            roles = new HashSet<>();
            roles.add(new Role(roleType));
        }
    }
}
