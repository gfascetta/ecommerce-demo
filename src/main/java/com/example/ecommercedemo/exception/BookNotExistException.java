package com.example.ecommercedemo.exception;

import lombok.Getter;
import lombok.Setter;

public class BookNotExistException extends RuntimeException {
    @Getter @Setter
    private Long bookId;
    public BookNotExistException(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String getMessage() {
        return "Book with id "+bookId+ " not exist";
    }
}
