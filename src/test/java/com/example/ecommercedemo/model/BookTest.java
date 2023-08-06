package com.example.ecommercedemo.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBook() {
        Book lotr = new Book("tolkien", "lotr", LocalDate.of(1990,11,30), "fantasy", 5f, LocalDateTime.now());
        assertEquals("tolkien", lotr.getAuthor());
        assertEquals(5f, lotr.getRate());
    }
}
