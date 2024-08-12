package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.securityMatcher("/articles/**")
                .authorizeHttpRequests(authorize -> authorize.anyRequest()
                .hasAuthority("SCOPE_articles.read"))   // see in authorization-server application.yaml
                .oauth2ResourceServer(oauth2 ->oauth2.jwt(Customizer.withDefaults()));
        return httpSecurity.build();
    }
}
