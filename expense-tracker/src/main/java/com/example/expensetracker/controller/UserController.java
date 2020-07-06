package com.example.expensetracker.controller;

import java.net.URISyntaxException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.expensetracker.model.User;
import com.example.expensetracker.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class UserController {
    
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @GetMapping("/users")
    public List<User> getUsers() {
        LOG.info("Getting all users.");
        return userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        LOG.info("Getting user with id: {} .", id);
        Optional <User> user = userRepository.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

 
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException{
        User res = userRepository.save(user);
        return ResponseEntity.created(new URI("/api/users" + res.getUserId())).body(res);
    }

    
}
    

    



