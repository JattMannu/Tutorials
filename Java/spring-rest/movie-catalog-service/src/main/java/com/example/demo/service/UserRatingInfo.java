package com.example.demo.service;

import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRatingInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserRating_fb",
    commandProperties = {
            //@HystrixProperty()
    }
    )
    public List<Rating> getUserRating(String userId) {
        return restTemplate
                .getForObject("http://RATING-DATA-SERVICE/ratingsData/users/" + userId, UserRating.class)
                .getUserRating();
    }

    public List<Rating> getUserRating_fb(String userId) {
        return Arrays.asList(new Rating("0", 0));
    }

}
