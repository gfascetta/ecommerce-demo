package com.example.ecommercedemo.persistence.impl;

import com.example.ecommercedemo.model.Book;
import com.example.ecommercedemo.persistence.IBookDAO;
import com.example.ecommercedemo.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDAOImpl implements IBookDAO {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public List<Book> getAllByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
