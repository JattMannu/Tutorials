package com.example.demo.service;

import com.example.demo.model.Fellowships;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FellowshipsService extends MongoRepository<Fellowships, Long> {
}
