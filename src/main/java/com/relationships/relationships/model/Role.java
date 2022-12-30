package com.relationships.relationships.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Role {
    private RoleType roleType;
    public Role(RoleType roleType){

        this.roleType = roleType;
    }
}
