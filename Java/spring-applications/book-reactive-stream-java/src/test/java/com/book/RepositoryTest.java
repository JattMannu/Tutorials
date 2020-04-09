package com.book;


import com.book.model.Book;
import com.book.repository.BookRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RepositoryTest {

    //https://www.youtube.com/watch?v=xjXHecGOy84

    @Autowired
    BookRepository  bookRepository;

    @Autowired
    ConnectionFactory connectionFactory;
    @Autowired
    DatabaseClient database;

    @BeforeTestClass
    public void setUp() {

        Hooks.onOperatorDebug();

        List<String> statements = Arrays.asList(//
                "DROP TABLE IF EXISTS customer;",
                "CREATE TABLE customer ( id SERIAL PRIMARY KEY, firstname VARCHAR(100) NOT NULL, lastname VARCHAR(100) NOT NULL);");

        statements.forEach(it -> database.execute(it) //
                .fetch() //
                .rowsUpdated() //
                .as(StepVerifier::create) //
                .expectNextCount(1) //
                .verifyComplete());
    }


    @Test
    void  saveBook(){

        Book book = new Book(1, "123");
        Mono<Book> save = bookRepository.save(book);
        save.subscribe();

//       bookRepository.findById(1l)
//               .as(StepVerifier::create)
//               .expectNextCount(1)
//               .verifyComplete();


    }
}

