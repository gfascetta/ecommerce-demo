package com.example.ecommercedemo.service;

import com.example.ecommercedemo.exception.BookNotExistException;
import com.example.ecommercedemo.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    List<Book> getAllBooksByAuthor(String author);

    Book getBookById(Long id) throws BookNotExistException;

    Long createBook(Book book);

    void deleteBook(Long id) throws BookNotExistException;

    Book updateBook(Long id, Book book) throws BookNotExistException;
}
