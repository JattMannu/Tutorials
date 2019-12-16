package com.example.demo.controller;

import com.example.demo.model.PersonalProfile;
import com.example.demo.model.Resume;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.service.PersonalProfileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    PersonalProfileService personalProfileService;

    // curl localhost:8084/resume | jq
    @GetMapping("/all")
    public List<Resume> getAllResumes(){
        return resumeRepository.findAll();
    }


}
