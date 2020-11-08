package com.example.demo.controller;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controllers.BookController;
import com.example.demo.models.Book;
import com.example.demo.service.BookService;

//@SpringBootTest
/*
 * @WebMvcTest(value = BookController.class)
 * 
 * @WithMockUser
 * 
 * @RunWith(junitplatform)
 */
@WebMvcTest(controllers = BookController.class)
@DisplayName("Testing the Book Controller")
public class TestBookController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	Book mockBookRequest = new Book(1,"Maven",12.4);
	
	@Test
	@DisplayName("When a User tries to update a book")
	public void testUpdateBook() throws Exception {
	
		Mockito.when(bookService.updateBook(Mockito.anyInt(), Mockito.any(Book.class))).thenReturn(mockBookRequest);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/book/1").content("{\"name\":\"Ameya\"}").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().toString());

		MockHttpServletResponse response = result.getResponse();
		
		System.out.println(response.getContentAsString());
			
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	}
}
