package com.example.demo;

import com.example.demo.model.Friend;
import org.springframework.context.annotation.Bean;

public class Setup {

    @Bean
    public Friend getFriend(){
        return new Friend("Moore" , "Eye");
    }
}
