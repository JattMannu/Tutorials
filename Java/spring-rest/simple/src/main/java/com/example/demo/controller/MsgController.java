package com.example.demo.controller;

import com.example.demo.model.Msg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @GetMapping("/msg")
    Msg send(){
        return new Msg("first msg");
    }

    @PostMapping("/msg")
    Msg echo(@RequestBody Msg msg){
        return msg;
    }

}
