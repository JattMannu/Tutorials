package com.example.demo.controller;

import com.example.demo.handlermapping.TimeBasedAccessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MyController {

    @Autowired
    TimeBasedAccessInterceptor timeBasedAccessInterceptor;

    @GetMapping("add")
    public String add(@RequestParam("numb1") int numb1, @RequestParam("numb2") int numb2, Model model) {
        log.info("Method : add() triggered.");
        model.addAttribute("result", numb1 + numb2);
        return "display";
    }

    @GetMapping("/")
    public String index() {
        log.info("Method : index() triggered.");
        return "index";
    }

    @GetMapping("done")
    public String done() {
        log.info("Method : done() triggered.");
        return "redirect:/";
    }
}
