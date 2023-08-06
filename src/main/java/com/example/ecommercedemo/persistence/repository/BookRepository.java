package com.example.ecommercedemo.persistence.repository;

import com.example.ecommercedemo.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.util.function.Tuple2;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    //List<Book> findAllByAuthorAndTitle(String author, String title);

    //JPQL
    @Query(value = "SELECT b FROM Book b WHERE b.author = :authorParam")
    List<Book> getBooksByAuthor(@Param("authorParam") String author);

    @Query(value = "SELECT b.id, b.author FROM Book b WHERE b.author = :authorParam")
    List<Tuple2<Long,String>> getBooksByAuthor2(@Param("authorParam") String author);
}
