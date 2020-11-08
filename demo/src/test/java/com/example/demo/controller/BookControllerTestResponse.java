package com.example.demo.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controllers.BookController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
@WithMockUser
public class BookControllerTestResponse {

}
