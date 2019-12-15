package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authentication.AuthenticationBean;


@CrossOrigin(origins = "http://localhost:1123")
@RestController
@RequestMapping("/api/v1")
public class BasicAuthenticationController {
	@GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

}
