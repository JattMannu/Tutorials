package com.example.demo.controller;

import com.example.demo.model.CatalogItem;
import com.example.demo.model.Movie;
import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    DiscoveryClient discoveryClient; //Use this to get the service info from Eurka

    // curl localhost:8081/catalog/1 | jq
    @GetMapping("/{userId}")
    public Iterable<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        //RestTemplate restTemplate = new RestTemplate(); //Autowired
        List<Rating> ratings = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsData/users/"+userId, UserRating.class).getUserRating();
        return ratings.stream().map(rating -> {
            //REST call to the MicroService.
            Movie movie = restTemplate.getForObject(
                    String.format("http://MOVIE-INFO-SERVICE/movies/%s", rating.getMovieId()), Movie.class);
            return new CatalogItem(movie.getName(), "Test Description ?"  , rating.getRating());
        }).collect(Collectors.toList());

        //return Collections.singleton(new CatalogItem("Transformers", "Test", 4));
    }


    // curl localhost:8081/catalog/wc/1 | jq
    @GetMapping("/wc/{userId}")
    public Iterable<CatalogItem> getCatalog_wc(@PathVariable("userId") String userId){

        //WebClient.Builder builder = WebClient.builder(); //Suppose to take over the rest template.

        //RestTemplate restTemplate = new RestTemplate(); //Autowired
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1234" , 3),
//                new Rating("5678" , 2)
//        );
        List<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratingsData/users/"+userId, UserRating.class).getUserRating();

        return ratings.stream().map(rating -> {
            //REST call to the MicroService.
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri(String.format("http://localhost:8082/movies/%s", rating.getMovieId()))
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            return new CatalogItem(movie.getName(), "Test Description ?"  , rating.getRating());
        }).collect(Collectors.toList());

        //return Collections.singleton(new CatalogItem("Transformers", "Test", 4));
    }
}
