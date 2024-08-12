package com.example.configuration;

import com.example.model.Contact;
import com.example.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactDBLoad {

    @Bean
    CommandLineRunner initDatabase(ContactRepository repository) {
        return args-> {
            System.out.println("Preloading " + repository.save(new Contact("Titi Cocos", "0727341552")));
            System.out.println("Preloading " + repository.save(new Contact("Mihaita Boss", "077777777")));
        };
    }
}
