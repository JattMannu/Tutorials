package com.example.demo.controller;

import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsData")
public class RatingController {

    // curl localhost:8083/ratingsData/1 | jq
    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,3);
    }

    // curl localhost:8083/ratingsData/users/1 | jq
    @GetMapping("/users/{userId}")
    public UserRating getRatingByUserId(@PathVariable("userId") String userId){
        List<Rating> ratingList = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        return new UserRating(ratingList);
    }
}
