package com.example.demo;

import com.example.demo.configuration.ProfileManager;
import com.example.demo.repository.ResumeRepository;
import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MongodbServiceApplication {

//	@Autowired
//	private ResumeRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(MongodbServiceApplication.class, args);
	}

}
