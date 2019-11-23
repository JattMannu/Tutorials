package com.example.demo;

import com.example.demo.model.Resume;
import com.example.demo.repository.ResumeRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ResumeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Resume("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Resume("Frodo Baggins", "thief")));
        };
    }
}