package com.jwt.validation.model;

import lombok.Data;

@Data
public class JWTRequest {
    private String token;
    private String userName;
}
