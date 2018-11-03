package com.mycompany.myapp.web.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// todo - for testing purposes, remove later
@RestController
public class DummyController {
    @RequestMapping("/api/dummy")
    public String getDummy() {
        return "Hello dummy";
    }
}
