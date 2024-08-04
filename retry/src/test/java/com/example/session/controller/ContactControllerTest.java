package com.example.session.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {

        @Value(value = "${local.server.port}")
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void testSimpleScenario() throws Exception{


        }

}
