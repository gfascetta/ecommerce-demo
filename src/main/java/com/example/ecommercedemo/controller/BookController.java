package com.example.ecommercedemo.controller;


import com.example.ecommercedemo.dto.CreateBookDTO;
import com.example.ecommercedemo.dto.UpdateBookDTO;
import com.example.ecommercedemo.exception.BookNotExistException;
import com.example.ecommercedemo.model.Book;
import com.example.ecommercedemo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) throws Exception {
        return bookService.getBookById(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBook(@PathVariable String author) {
        return bookService.getAllBooksByAuthor(author);
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Long createBook(@RequestBody @Validated CreateBookDTO createBookDTO) {
        return bookService.createBook(createBookDTO.mapToBook());
    }

    @PutMapping("/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody  @Validated UpdateBookDTO updateBookDTO) throws BookNotExistException {

        return bookService.updateBook(id, updateBookDTO.mapToBook());
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) throws BookNotExistException {
        bookService.deleteBook(id);
        return "Libro con id " + id + " eliminado exitosamente";
    }
}
