package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Minecraft1Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Minecraft1Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("executed...");
	}


}
