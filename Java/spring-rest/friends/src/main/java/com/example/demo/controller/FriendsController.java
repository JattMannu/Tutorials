package com.example.demo.controller;

import com.example.demo.model.Friend;
import com.example.demo.services.FriendsService;
import com.example.demo.util.ErrorMessage;
import com.example.demo.util.FieldErrorMessage;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FriendsController {

    @Autowired
    FriendsService friendsService;

    // BEFORE
//    @PostMapping("/friend")
//    Friend create(@RequestBody Friend friend){
//        if(friend.getId() == 0 && friend.getLastName() != null && friend.getFirstName() != null)
//            return friendsService.save(friend);
//        else
//            throw new ValidationException("friend cannot be created.");
//    }

    @PostMapping("/friend")
    Friend create(@Valid @RequestBody Friend friend){
        return friendsService.save(friend);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        return fieldErrors.stream().map(fieldError ->
                new FieldErrorMessage(fieldError.getField(),
                        fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
    }


    @GetMapping("/friend")
    Iterable<Friend> read(){
        return friendsService.findAll();
    }

    @GetMapping("/friend/{id}")
    Optional<Friend> read(@PathVariable Integer id){
        return friendsService.findById(id);
    }

    @GetMapping("/friend/search")
    Iterable<Friend> findByQuery(
            @RequestParam(value = "first", required = false) String firstName,
            @RequestParam(value = "last", required = false) String lastName
    ){
        if(firstName != null && lastName != null)
            return friendsService.findByFirstNameAndLastName(firstName,lastName);
        else if (firstName != null)
            return friendsService.findByFirstName(firstName);
        else if ( lastName != null)
            return friendsService.findByLastName(lastName);
        else
            return friendsService.findAll();
    }


    @PutMapping("/friend")
    ResponseEntity<Friend> update(@RequestBody Friend friend){
        if(friendsService.findById(friend.getId()).isPresent())
            return new ResponseEntity<>(friendsService.save(friend), HttpStatus.OK);
        else
            return new ResponseEntity<>(friend, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/friend/{id}")
    void delete(@PathVariable Integer id){
        friendsService.deleteById(id);
    }
}

