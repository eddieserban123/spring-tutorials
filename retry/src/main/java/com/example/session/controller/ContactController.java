package com.example.session.controller;


import com.example.session.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    private final MyService service;

    ContactController(MyService service) {
        this.service = service;}

    @GetMapping("/contacts")
    public String process() {

        service.callRemoteService();
        return "done";

    }
}
