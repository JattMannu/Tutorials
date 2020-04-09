package com.book;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@SpringBootTest
public class ReactorTest {

    // https://projectreactor.io/docs/core/release/api/ Go to "Appendix A: Which operator do I need?" section.
    // https://projectreactor.io/docs/core/release/reference/
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

    @Test
    void monoTest5() throws InterruptedException {
        // Mono is a Publisher.
        // How do i create a mono?
        int count = 0;
        System.out.println("------" + count++);
        Mono.just("Test1").subscribe(s -> System.out.println(s));

        System.out.println("------" + count++);
        Mono.justOrEmpty("Test2").subscribe(s -> System.out.println(s));

        System.out.println("------" + count++); // 3
        Mono.justOrEmpty(null).doOnSuccess(o -> System.out.println("Success")).subscribe(o -> System.out.println(o));

        System.out.println("------" + count++);
        Mono.justOrEmpty(Optional.of("Test3")).doOnSuccess(o -> System.out.println("Success")).subscribe(o -> System.out.println(o));

        System.out.println("------" + count++);
        Mono.justOrEmpty(Optional.empty()).doOnSuccess(o -> System.out.println("Success")).subscribe(o -> System.out.println(o));

        System.out.println("------" + count++);
        Mono.fromSupplier(() -> "From Supplier").subscribe(s -> System.out.println(s));

        System.out.println("------" + count++);
        Mono.fromSupplier(() -> {
            LinkedList linkedList = new LinkedList();
            linkedList.add("String in list #1");
            linkedList.add("String in list #2");
            linkedList.add("String in list #3");
            return linkedList;
        }).subscribe(s -> s.parallelStream().forEach(o -> System.out.println(o)));

        System.out.println("------" + count++);
        Flux.just("Apple", "Banana", "Carrot").subscribe(s -> System.out.println(s));

        System.out.println("------" + count++);
        Flux.fromArray(new Integer[]{1, 2, 4, 5}).subscribe(s -> System.out.println(s));

        System.out.println("------" + count++);
        {
            LinkedList linkedList = new LinkedList();
            linkedList.add("String in list #1");
            linkedList.add("String in list #2");
            linkedList.add("String in list #3");
            Flux.fromIterable(linkedList).subscribe(s -> System.out.println(s));

        }

        System.out.println("------" + count++);
        /*
        Iterator vs Spliterator
            Iterator                                        Spliterator
            Introduced in Java 1.2.	                        Introduced in Java 1.8.
            It is an Iterator for whole                     Collection API.	It is an Iterator for both Collection and Stream API, except Map implemented classes.
            It is an Universal Iterator.	                It is NOT an Universal Iterator.
            It does NOT support Parallel Programming.	    It supports Parallel Programming.

         Advantages of Spliterator
            Unlike Iterator and ListIterator, it supports Parallel Programming functionality.
            Unlike Iterator and ListIterator, it supports both Sequential and Parallel Processing of data.
            Compare to other Iterators, it provides better performance.
         */
        {
            List<String> arrayList = new ArrayList<>();
            arrayList.add("Rams");
            arrayList.add("Posa");
            arrayList.add("Chinni");

            // Getting Spliterator
            Spliterator<String> namesSpliterator = arrayList.spliterator();

            namesSpliterator.forEachRemaining(System.out::println);
        }


        System.out.println("------" + count++);
        IntStream build = IntStream.builder().add(1).add(2).add(3).build();
        Flux.fromStream(build.boxed()).subscribe(integer -> System.out.println(integer));

        System.out.println("------" + count++);
        Mono.fromSupplier(() -> 47).subscribe(integer -> System.out.println(integer));

        System.out.println("------" + count++);
        Mono.fromCallable(() -> "Test5").subscribe(s -> System.out.println(s));


        {
            System.out.println("------" + count++);
            CompletableFuture<String> completableFuture = new CompletableFuture<>();
            Executors.newCachedThreadPool().submit(() -> {
                Thread.sleep(500);
                completableFuture.complete("Hello");
                return null;
            });

            Mono.fromFuture(completableFuture).subscribe(s -> System.out.println(s));
            Thread.sleep(1000);
        }

        {
            System.out.println("------" + count++);
            Mono.empty().doOnSuccess(o -> System.out.println("doOnSuccess " + o)).subscribe(o -> System.out.println(o));
        }

        {
            System.out.println("------" + count++);
            Mono.error(RuntimeException::new).doOnError(throwable -> System.out.println("handled")).onErrorContinue((throwable, o) -> System.out.println("handled the error")).subscribe(o -> System.out.println(o));
        }

        // Never
        {
            System.out.println("------" + count++);
            Mono.never().repeat(10).subscribe(o -> System.out.println(o));
        }


        // Defer
        {
            System.out.println("------" + count++);
            {
                System.out.println("Without defer");
                long start = System.currentTimeMillis();
                Mono<Long> clock = Mono.just(System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(clock.block() - start); //we use block for demonstration purposes, returns t0
                Thread.sleep(1000);
                System.out.println(clock.block() - start); //we re-subscribe to clock, still returns t0
            }
            {
                long start = System.currentTimeMillis();
                System.out.println("With defer");
                Mono<Long> clock = Mono.defer(() -> Mono.just(System.currentTimeMillis()));
                Thread.sleep(2000);
                System.out.println(clock.block() - start); //we use block for demonstration purposes, returns t0
                Thread.sleep(1000);
                System.out.println(clock.block() - start); //we re-subscribe to clock, still returns t0
            }
        }

        // Using
        {
            //------19
            //resourceCleanup: asd
            //subscribe: sourceSupplier: asd
            System.out.println("------" + count++);
            Mono.using(() -> "asd", s -> Mono.just("sourceSupplier: " + s), s -> System.out.println("resourceCleanup: " + s), true).subscribe(o -> System.out.println("subscribe: " + o));
        }


        // http://www.vinsguru.com/reactive-programming-flux-create-vs-generate/
        // Flux#generate : synchronously and one-by-one
        {
            System.out.println("------" + count++);

//            Flux.generate((SynchronousSink<Integer> synchronousSink) -> { synchronousSink.next(1); })
//                    .doOnNext(number -> System.out.println(number))
//                    .subscribe();

            AtomicInteger atomicInteger = new AtomicInteger();

            //Flux generate sequence
            Flux<Integer> integerFlux = Flux.generate((SynchronousSink<Integer> synchronousSink) -> {
                System.out.println("Flux generate");
                synchronousSink.next(atomicInteger.getAndIncrement());
            });

            //observer
            integerFlux.delayElements(Duration.ofMillis(50))
                    .subscribe(i -> System.out.println("First consumed ::" + i));


            Thread.sleep(3000);
        }

        {
            // Flux#create  and Mono#create
            System.out.println("------" + count++);



        }

    }


    @Test
    void Sample_Supplier() {
        Mono.fromSupplier(new SampleSupplier()).subscribe(s -> System.out.println(s));
    }

    class SampleSupplier implements Supplier<String> {

        @Override
        public String get() {
            return "Sample Supplier String";
        }
    }


    @Test
    void mono_transforming(){
        int count = 0;
        {
            System.out.println("------" + count++);
            Mono.just("Apple").map(s -> s.length()).subscribe(integer -> System.out.println(integer));
        }

        System.out.println("------" + count++);
        Flux.just("1","2","3","4","5").index((aLong, integer) -> (aLong + " "+ integer)).subscribe(s -> System.out.println(s));

        System.out.println("------" + count++);
        Flux.just("1","2","3","4","5").flatMap(s -> Mono.defer(() ->{
            try {
                Thread.sleep(500);
                System.out.println("Sleeping for 0.5 sec");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Mono.just(s);
        })).subscribe(s -> System.out.println(s));


        Flux.just("1","2","3","4","5").map(s -> Mono.defer(() ->{
            try {
                Thread.sleep(500);
                System.out.println("Sleeping for 0.5 sec");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Mono.just(s);
        }).block() //Added this
        ).subscribe(s -> System.out.println(s));


        // Handle
        System.out.println("------" + count++);
        Flux.just("1","2","3","4","5").handle((s, synchronousSink) -> synchronousSink.next(s)).subscribe(o -> System.out.println(o));

        // Flux#flatMapSequential : (this triggers the async processes immediately but reorders the results)
        System.out.println("------" + count++);
        Flux.just("1","2","3","4","5").flatMapSequential(s -> Flux.just(s.length())).subscribe(o -> System.out.println(o));

        System.out.println("------" + count++);
        Flux.just("1","2","3","4","5").flatMap(s -> Mono.just(Integer.parseInt(s))).all(integer -> integer< 19).subscribe(aBoolean -> System.out.println(aBoolean));


        System.out.println("------" + count++);
        Flux.just("1","2","3","4","5").flatMap(s -> Mono.just(Integer.parseInt(s))).any( integer -> integer <  0).subscribe(aBoolean -> System.out.println(aBoolean));


        System.out.println("------" + count++);
        Flux.just("1","2","3","4","5").flatMap(s -> Mono.just(Integer.parseInt(s))).filter( integer -> integer < 0).hasElements().subscribe(aBoolean -> System.out.println(aBoolean));

        System.out.println("------" + count++);
        Flux.just("1","4","3","4","5").flatMap(s -> Mono.just(Integer.parseInt(s))).filter( integer -> integer < 3).hasElement(2).subscribe(aBoolean -> System.out.println(aBoolean));


    }
}
