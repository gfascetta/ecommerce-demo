package com.example.ecommercedemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //@Column(name = "author")
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String title;
    private LocalDate releaseDate;
    @Column(nullable = false)
    private String genre;
    private Float rate;
    private LocalDateTime createdOn;

    //CONSTRUCTOR
    public Book() {
    }

    public Book(String author, String title, LocalDate releaseDate, String genre, Float rate, LocalDateTime createdOn) {
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rate = rate;
        this.createdOn = createdOn;
    }

    public void merge(Book bookToMerge) {
        this.author = bookToMerge.author;
        this.title = bookToMerge.title;
        this.genre = bookToMerge.genre;
        this.rate = bookToMerge.rate;
    }

}
