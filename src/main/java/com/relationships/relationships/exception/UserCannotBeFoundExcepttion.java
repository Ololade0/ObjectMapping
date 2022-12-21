package com.relationships.relationships.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCannotBeFoundExcepttion extends RuntimeException{
    private int statusCode;
    public UserCannotBeFoundExcepttion(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;

    }


}
