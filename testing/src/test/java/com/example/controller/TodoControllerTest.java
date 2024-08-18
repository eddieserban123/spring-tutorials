package com.example.controller;


import com.example.model.Todo;
import com.example.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({TodoController.class})
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testTodoController() throws Exception {
        List<Todo> todos = List.of(new Todo("todo1", true), new Todo("todo2", false));
        Mockito.when(todoService.findAll()).thenReturn(todos);

        mockMvc.perform(get("/"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(todos))
                );


    }

}
