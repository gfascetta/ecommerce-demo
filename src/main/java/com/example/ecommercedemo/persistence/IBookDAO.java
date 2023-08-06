package com.example.ecommercedemo.persistence;

import com.example.ecommercedemo.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {
    List<Book> getAll();
    List<Book> getAllByAuthor(String author);

    Book save(Book book);

    Optional<Book> getBookById(Long id);

    void deleteBookById(Long id);
}

