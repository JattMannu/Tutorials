package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class R2DbcConfigDemo1Application {

	private static final Logger log = LoggerFactory.getLogger(R2DbcConfigDemo1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(R2DbcConfigDemo1Application.class, args);
	}


	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.saveAll(Arrays.asList(
					new Book("Jack", 2),
					new Book("Chloe", 1),
					new Book("Kim", 8),
					new Book("David", 3),
					new Book("Michelle", 1)))
					.blockLast(Duration.ofSeconds(10));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().doOnNext(book -> {
				log.info(book.getName());
			}).blockLast(Duration.ofSeconds(10));

			log.info("");
		};
	}
}
