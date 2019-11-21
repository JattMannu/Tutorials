package com.example.demo;

import com.example.demo.controller.FriendsController;
import com.example.demo.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

    @Autowired
    FriendsController friendsController;


    @Test
    public  void testCreateReadDelete(){
        Friend friend  = new Friend("Moore" , "Eye");

        Friend friendResult = friendsController.create(friend);

        Iterable<Friend> friends = friendsController.read();
        Assertions.assertThat(friends).last().hasFieldOrPropertyWithValue("firstName", friendResult.getFirstName());

        friendsController.delete(friend.getId());
        Assertions.assertThat(friendsController.read()).doesNotContain(friend);


    }
}
