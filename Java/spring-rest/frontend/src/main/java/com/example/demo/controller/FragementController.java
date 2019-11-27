package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragementController {

    //https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html#default-expressions-elvis-operator


    @GetMapping("/fragments")
    public String getHome() {
        return "fragments.html";
    }

    @GetMapping("/markup")
    public String markupPage() {
        return "markup.html";
    }

    @GetMapping("/params")
    public String paramsPage() {
        return "params.html";
    }

    @GetMapping("/other")
    public String otherPage(Model model) {
        return "other.html";
    }

    @GetMapping("/")
    public String resume(Model model) {
        //model.addAttribute("title", new String("Simmiasdasd"));
        return "index1";
    }
}
