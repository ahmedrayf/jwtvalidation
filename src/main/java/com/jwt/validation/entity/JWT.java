package com.jwt.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RedisHash("JWT")
public class JWT implements Serializable {

    @Id
    private String token;
    @Indexed
    private String userName;
}
