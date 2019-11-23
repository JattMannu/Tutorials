package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;



@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard //http://localhost:8081/hystrix , ALso read bulkhead pattern
public class MovieCatalogServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getInstancRestTemplate(){

		//TIMEOUT TIME-OUT TIME OUT <> Not the preferred way to setting timeout
		//	HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		//	clientHttpRequestFactory.setConnectTimeout(3000);
		//	return new RestTemplate(clientHttpRequestFactory);

		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder getInstanceWebClientBuilder(){
		return WebClient.builder(); //Suppose to take over the rest template.
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
