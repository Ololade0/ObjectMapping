package com.relationships.relationships.dao.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserLoginResponse {
    private int code;
    private String message;
}
