package com.example.ecommercedemo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {
    @Getter
    @Setter
    private Long id;
    public UserNotFound(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "User with id "+id+ " not exist";
    }
}
