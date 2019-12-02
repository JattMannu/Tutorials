package com.example.demo.service;

import com.example.demo.model.Skills;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillsService extends MongoRepository<Skills, Long> {
}
