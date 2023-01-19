package com.nnk.springboot.controller;

import com.nnk.springboot.controllers.HomeController;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Unit test for HomeController
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@WithMockUser
public class LoginControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void login() throws Exception {
        //WHEN
        mvc.perform(get("/login"))
                //THEN
                .andExpect(status().isOk());
    }
    @Test
    public void error() throws Exception {
        //WHEN
        mvc.perform(get("/error"))
                //THEN
                .andExpect(status().is5xxServerError());
    }
}
