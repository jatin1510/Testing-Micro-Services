package com.jatin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081", value = "Token-Client")
public interface TokenClient {
    @GetMapping("/token/{email}")
    public String createToken(@PathVariable String email);

    @GetMapping("/token/verify/{uId}")
    public boolean verifyToken(@PathVariable String uId);

    @GetMapping("/token/remove/{uId}")
    public void removeToken(@PathVariable String uId);

    @GetMapping("/token/email/{uId}")
    public String getEmail(@PathVariable String uId);
}
