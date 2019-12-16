package com.example.demo.controller;

import com.example.demo.model.PersonalProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping()
    public PersonalProfile get(){
        return new PersonalProfile(1,"Hi Simmi, I love you very much. Regards, Manpreet");
    }



}
