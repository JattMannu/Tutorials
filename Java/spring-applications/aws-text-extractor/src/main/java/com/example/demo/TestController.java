package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("test")
public class TestController {

    // curl localhost:8080/test | jq
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity> get(){
        return Mono.just("{ \"msg\" : \"Hello World\"}")
                .map(s -> ResponseEntity.status(HttpStatus.OK).body(s))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR"));
    }




}
