package com.example.service;

import com.example.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public List<Todo> findAll() {
        return List.of(new Todo("todo1",true), new Todo("todo2", false));
    }
}
