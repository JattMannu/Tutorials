package com.example.demo;


import com.example.demo.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SystemTest {

    @Test
    public void testCreateReadDelete(){
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/friend";

        Friend friend = new Friend("tommy", "jerry");

        ResponseEntity<Friend> entity = restTemplate.postForEntity(url,friend,Friend.class);

        Friend[] friends = restTemplate.getForObject(url, Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).contains(friend.getFirstName());

        restTemplate.delete(url+"/"+ entity.getBody().getId());
        Assertions.assertThat(restTemplate.getForObject(url,Friend[].class)).extracting(Friend::getFirstName).doesNotContain(friend.getFirstName());


    }
}
