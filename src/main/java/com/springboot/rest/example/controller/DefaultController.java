package com.springboot.rest.example.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
class DefaultController {

    @GetMapping("/")
    public ResponseEntity<Object> showHomePage() {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/swagger-ui/index.html")).build();
    }

    // @GetMapping("/")
    // public String index() {
    //     return "index";
    // }

}