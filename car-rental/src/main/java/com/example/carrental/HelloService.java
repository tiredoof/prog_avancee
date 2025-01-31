package com.example.carrental;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloService {
    @GetMapping("/")
    public String hello() {
        return "Hello, Car Rental Service!";
    }
}
