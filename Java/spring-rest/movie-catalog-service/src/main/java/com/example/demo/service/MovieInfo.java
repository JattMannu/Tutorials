package com.example.demo.service;

import com.example.demo.model.CatalogItem;
import com.example.demo.model.Movie;
import com.example.demo.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCatalogItem_fb")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie=  restTemplate.getForObject(
                String.format("http://MOVIE-INFO-SERVICE/movies/%s", rating.getMovieId()), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDesc() , rating.getRating());
    }

    public CatalogItem getCatalogItem_fb(Rating rating) {
        return new CatalogItem("Movie name not found", "" , rating.getRating());
    }
}
