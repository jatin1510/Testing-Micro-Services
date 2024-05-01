package com.jatin.controller;

import com.jatin.model.User;
import com.jatin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization") String jwt) throws Exception {
        return new ResponseEntity<>(userService.findUserByJwtToken(jwt), HttpStatus.OK);
    }

    @GetMapping("/find-by-jwt")
    public User findByJwt(@RequestHeader("Authorization") String jwt) throws Exception {
        System.out.println("jwt: " + jwt);
        return userService.findUserByJwtToken(jwt);
    }

    @GetMapping("/find-by-email/{email}")
    public User findByEmail(@PathVariable String email) throws Exception {
        return userService.findUserByEmail(email);
    }
}
