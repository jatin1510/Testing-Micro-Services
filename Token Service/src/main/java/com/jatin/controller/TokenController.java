package com.jatin.controller;

import com.jatin.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping("/{email}")
    String createToken(@PathVariable String email) {
        return tokenService.generateToken(email);
    }

    @GetMapping("/verify/{uId}")
    boolean verifyToken(@PathVariable String uId) {
        return tokenService.verifyToken(uId);
    }

    @GetMapping("/remove/{uId}")
    void removeToken(@PathVariable String uId) {
        tokenService.removeToken(uId);
    }

    @GetMapping("/email/{uId}")
    String getEmail(@PathVariable String uId) throws Exception {
        return tokenService.getEmail(uId);
    }
}
