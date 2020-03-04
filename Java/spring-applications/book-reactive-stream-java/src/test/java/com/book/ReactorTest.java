package com.book;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootTest
public class ReactorTest {

    @Test
    void printString() {
        Flux.range(1, 100)
                .publishOn(Schedulers.parallel())
                .subscribe(v -> System.out.println(v));
    }

    @Test
    void monoTest() {
        Mono.just("hello").onErrorStop().subscribe(s -> System.out.println(s));
    }

    @Test
    void monoTest1() {
        Mono.just("hello").log().subscribe(); //Cold
    }

    @Test
    void monoTest2() {
        Mono.just("hello")
                .log()
                .doOnSubscribe(subscription -> System.out.println("subs" + subscription))
                .doOnRequest(value -> System.out.println("Resquest : " + value))
                .doOnSuccess(s -> System.out.println("complete" + s))
                .subscribe(System.out::println); // Method reference
    }

    @Test
    void monoTest3() {
        Mono.empty()
                .log()
                .subscribe(System.out::println, null, () -> System.out.println("DONE")); // Method reference
    }
    @Test
    void monoTest4() {
//        Mono.error(new Exception())
//                .onErrorResume(throwable -> System.out.println(throwable.getMessage()))
//                .log()
//                .subscribe(System.out::println, null, () -> System.out.println("DONE")); // Method reference
    }


}
