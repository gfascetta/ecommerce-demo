package com.example.ecommercedemo.dto;

import com.example.ecommercedemo.model.Book;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateBookDTO {

        @NotEmpty
        private String author;
        @NotEmpty private String title;
        @NotEmpty private String genre;
        @Min(1) @Max(5) private Float rate;

        public Book mapToBook() {
            return new Book(author, title, null, genre, rate, null);
        }
}
