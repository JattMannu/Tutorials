package com.example.demo.service;

import com.example.demo.model.Publications;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PublicationsService extends MongoRepository<Publications,Long> {
}
