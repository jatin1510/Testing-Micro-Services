package com.jatin.service;

import com.jatin.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8082", value = "User-Service-Client")
public interface UserService {
    @GetMapping("/users/find-by-jwt")
    public User findUserByJwtToken(String jwt);

    @GetMapping("/users/find-by-email/{email}")
    public User findByEmail(@PathVariable String email);
}
