package com.example.demo.controller;

import com.example.demo.model.Movie;
import org.bson.BSONEncoder;
import org.bson.BsonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Value("${api.key}")
    private String apikey;

    @Autowired
    @Qualifier("apple1")
    private RestTemplate restTemplate;

    @Autowired
    private BSONEncoder bsonEncoder;

    //  curl localhost:8082/movies/550 | jq
    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

        // BsonDocument bsonDocument = new BsonDocument().
        BsonDocument document = BsonDocument.parse(
                restTemplate.getForObject(
                        String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s", movieId , apikey)
                        , String.class)
        );

        return new Movie(movieId,
                document.get("original_title").asString().getValue(),
                document.get("overview").asString().getValue());
    }

    /*

     List<Employee> list_response = restTemplate.getForObject(this.url, List.class); <-WRONG

    //CORRECT
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Employee>> response = restTemplate.exchange(
      "http://localhost:8080/employees/",
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<List<Employee>>(){});
      List<Employee> employees = response.getBody();
     */
}
