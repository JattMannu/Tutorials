package com.example.demo.services;

import com.example.demo.model.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendsService extends CrudRepository<Friend,Integer> {

    Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);
    Iterable<Friend> findByFirstName(String firstName);
    Iterable<Friend> findByLastName(String lastName);

}
