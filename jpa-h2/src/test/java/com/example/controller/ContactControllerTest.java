package com.example.controller;

import com.example.jpah2.SpringMainApplication;
import com.example.model.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,  classes = SpringMainApplication.class)
public class ContactControllerTest {

        @Value(value = "${local.server.port}")
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void testSimpleScenario() throws Exception{

            ParameterizedTypeReference<List<Contact>> responseType = new ParameterizedTypeReference<List<Contact>>() {};
            ResponseEntity<List<Contact>> res  = restTemplate
                    .exchange("/contacts", HttpMethod.GET,null, responseType);

            assertThat("List doesn't have correct len ", res.getBody().size()==2);

        }

}
