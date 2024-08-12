package com.example.controller;

import com.example.model.Contact;
import com.example.repository.ContactRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {
    private final ContactRepository repository;

    ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contacts")
    public List<Contact> process() {
        return repository.findAll();
    }
}
