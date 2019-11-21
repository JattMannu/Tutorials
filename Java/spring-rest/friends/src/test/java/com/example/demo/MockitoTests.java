package com.example.demo;

import com.example.demo.controller.FriendsController;
import com.example.demo.model.Friend;
import com.example.demo.services.FriendsService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(FriendsController.class)
public class MockitoTests {

    @MockBean
    FriendsService friendsService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception{
        Friend friend  = new Friend("Moore1" , "Eye");

        List<Friend> friends = Arrays.asList(friend);

        Mockito.when(friendsService.findAll()).thenReturn(friends);

        mockMvc.perform( MockMvcRequestBuilders
                .get("/friend")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].first-name",Matchers.is(friend.getFirstName())));

    }

}
