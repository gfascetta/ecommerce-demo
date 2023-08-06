package com.example.ecommercedemo.service.impl;

import com.example.ecommercedemo.exception.BookNotExistException;
import com.example.ecommercedemo.model.Book;
import com.example.ecommercedemo.persistence.IBookDAO;
import com.example.ecommercedemo.service.IBookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return bookDAO.getAllByAuthor(author);
    }

    @Override
    public Book getBookById(Long id) throws BookNotExistException {
        Optional<Book> maybeBook = bookDAO.getBookById(id);
        if (maybeBook.isEmpty()) {
            throw new BookNotExistException(id);
        }
        //return maybeBook.orElseGet(Book::new);
        return maybeBook.get();
    }

    @Override
    public Long createBook(Book book) {
        return bookDAO.save(book).getId();
    }

    @Override
    public void deleteBook(Long id) throws BookNotExistException {
        getBookById(id);
        bookDAO.deleteBookById(id);
    }

    @Override
    @Transactional
    public Book updateBook(Long id, Book book) throws BookNotExistException {
        Book persistedBook = getBookById(id);
        persistedBook.merge(book);
        return bookDAO.save(persistedBook);
    }
}
