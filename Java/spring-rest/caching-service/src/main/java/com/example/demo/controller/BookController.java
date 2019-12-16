package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cache")
public class BookController {

    @GetMapping("")
    @Cacheable("books")
    ResponseEntity<Book> get(){
        simulateSlowService();
        return new ResponseEntity<Book>(new Book("123", " asdasd"), HttpStatus.OK);
    }


    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
