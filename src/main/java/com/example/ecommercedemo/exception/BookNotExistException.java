package com.example.ecommercedemo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Book not exist")
public class BookNotExistException extends Exception {
    @Getter private Long bookId;
    public BookNotExistException(Long bookId) {
        this.bookId = bookId;
    }
}
