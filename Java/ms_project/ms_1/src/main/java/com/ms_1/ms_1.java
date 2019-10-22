package com.ms_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ms_1 {


    public static void main(String... args){
        // Tell Boot to look for registration-server.yml
       // System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(ms_1.class, args);
    }




}
