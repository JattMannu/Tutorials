package com.example.demo.controller;


import com.example.demo.model.PersonalProfile;
import com.example.demo.service.PersonalProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("personal-profile")
public class PersonalProfileController {

    //Notes : https://docs.spring.io/spring-data/mongodb/docs/1.3.3.RELEASE/reference/html/mongo.repositories.html


    @Autowired
    private PersonalProfileService personalProfileService;

    // curl localhost:8084/personal-profile/1 | jq
    @ApiOperation(value = "Get the profile of the person by ID", produces = "application/json" , consumes = "application/json")
    @GetMapping("/{id}")
    public ResponseEntity<PersonalProfile> get(@ApiParam(value = "Id of the person", required = true)@PathVariable long id) {
        Optional<PersonalProfile> personalProfile = personalProfileService.findById(id);
        if (personalProfile.isPresent())
            return new ResponseEntity<>(personalProfile.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //curl -X PUT http://localhost:8084/personal-profile -d '{  "id": 1, "profile":"Hello!" }'
    @PutMapping
    public ResponseEntity<PersonalProfile> update(@RequestBody PersonalProfile personalProfile) {
        if (personalProfileService.findById(personalProfile.getId()).isPresent())
            return new ResponseEntity<>(personalProfileService.save(personalProfile), HttpStatus.OK);
        else
            return new ResponseEntity<>(personalProfile, HttpStatus.BAD_REQUEST);
    }


}
