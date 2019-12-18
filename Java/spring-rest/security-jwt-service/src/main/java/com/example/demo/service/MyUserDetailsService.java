package com.example.demo.service;

import com.example.demo.model.MyUserDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Code , load the user from anywhere, Database etc
        //return new User("admin","admin", new ArrayList<>());
        //The user is not even used to check.
        //return new User("user111",userRepository.findByUsername(userName).getPassword(),new ArrayList<>());
        //return new User(email,userRepository.findByEmail(email).getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

        Optional<User> user = userRepository.findByEmail(email);
        return new MyUserDetails(user.get());
    }
}

