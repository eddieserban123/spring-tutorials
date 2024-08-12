package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ArticlesController {

    @GetMapping("/articles")
    public List<String> getArticles(){
        return List.of("article1","article2","article3" );
    }

}
