package com.alunoonline.api.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("contentClasses")
public class ContentClass {

    @Id
    private String id;
    private String value;
}
