package com.example.demo.service;

import com.example.demo.model.ResearchExperiences;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResearchExperiencesService extends MongoRepository<ResearchExperiences, Long> {
}
