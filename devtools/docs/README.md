Spring Boot DevTools is a helpful library that provides several features to enhance the development experience, 
including automatic restarts, live reload, and configurations for development environments

beside adding
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<optional>true</optional>
</dependency>

you need also to add:
in properties this:

spring.devtools.restart.enabled=true
spring.devtools.livereload.enabled=true

And after running go change myService definition !
