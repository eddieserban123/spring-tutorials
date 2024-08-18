package com.example.controller;

import com.example.config.Security;
import com.example.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({HomeController.class, AuthController.class, TokenService.class})
@Import({Security.class, TokenService.class})
public class HomeControllerTest {

    @Autowired
    MockMvc mvc;


    @Test
    void rootWhenUnauthenticated401() throws Exception {
        this.mvc.perform(get("/")).andExpect(status().isUnauthorized());
    }

    @Test
    void rootWhenAuthenticatedThenSayHello() throws Exception {
        MvcResult mvcResult = this.mvc.perform(post("/token")
                        .with(httpBasic("titi", "password")))
                .andExpect(status().isOk())
                .andReturn();
        String token = mvcResult.getResponse().getContentAsString();
        this.mvc.perform(get("/").header("Authorization", "Bearer " + token))
                .andExpect(content().string("Hello, JWT!"));
    }

    @Test
    @WithMockUser
    public void rootWithMockUserStatusIsOk() throws Exception {
        this.mvc.perform(get("/")).andExpect(status().isOk());
    }
}
