package com.example.jpah2.configuration;

import com.example.jpah2.model.Contact;
import com.example.jpah2.repository.ContactRepository;
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
