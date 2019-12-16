package com.example.demo.controller;

import com.example.demo.model.PersonalProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("home")
    public PersonalProfile get(){
        return new PersonalProfile(1,"Hello World!");
    }

    @GetMapping()
    public String home() {
        return "redirect:swagger-ui.html";
    }

}
