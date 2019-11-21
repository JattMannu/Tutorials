package com.example.demo;

import com.example.demo.model.Friend;
import com.example.demo.services.FriendsService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTest {

    @Autowired
    FriendsService friendsService;

    @Test
    public void testCreateReadDelete(){
        Friend friend  = new Friend("Moore" , "Eye");

        Friend friendResult = friendsService.save(friend);

        Iterable<Friend> friends = friendsService.findAll();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName", friendResult.getFirstName());

        friendsService.deleteAll();
        Assertions.assertThat(friendsService.findAll()).isEmpty();


    }

}
