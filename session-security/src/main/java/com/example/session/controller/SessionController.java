package com.example.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @RequestMapping("/")
    public String helloAdmin() {
        return "hello admin";
    }
}
