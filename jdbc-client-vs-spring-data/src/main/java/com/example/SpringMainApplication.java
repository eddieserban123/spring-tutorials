package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository repository) {
        return args -> {
            repository.save(new Post("1234", "Hello, World!", "hello-world", LocalDate.now(), 10, "Spring Boot", null));
            List<Post> posts = repository.findAll();
            System.out.println(posts);

            repository.findBySlug("hello-world").ifPresent(System.out::println);

        };
    }
}