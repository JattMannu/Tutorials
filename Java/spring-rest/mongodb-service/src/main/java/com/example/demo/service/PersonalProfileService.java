package com.example.demo.service;

import com.example.demo.model.PersonalProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalProfileService extends MongoRepository<PersonalProfile, Long> {
}
