package com.relationships.relationships.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String firstName;
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
