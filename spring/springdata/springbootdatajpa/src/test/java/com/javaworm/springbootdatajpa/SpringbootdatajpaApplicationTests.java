package com.javaworm.springbootdatajpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaworm.springbootdatajpa.contoller.CustomerController;
import com.javaworm.springbootdatajpa.model.Customer;
import com.javaworm.springbootdatajpa.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@WebAppConfiguration
public class SpringbootdatajpaApplicationTests {

	@Autowired
	private MockMvc mockMVC;

	@MockBean
	CustomerService customerService;

	protected void setUp() {
		//mockMVC = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	
	
	@Test
	public void getAllCustomers() throws Exception {
	   String uri = "/allcustomer";
	   
	   Customer Abir = new Customer();
	   Abir.setFirstName("Abir");
	   Abir.setLastName("khan");
	   List<Customer> allCustomers = Arrays.asList(Abir);	    
	   Mockito.when(customerService.findAllCustomer()).thenReturn(allCustomers);
       
	   
	   MvcResult mvcResult = mockMVC.perform(MockMvcRequestBuilders.get("/allcustomer").contentType(MediaType.APPLICATION_JSON)).andReturn();
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
       String content = mvcResult.getResponse().getContentAsString();
       Customer[] customerlist = mapFromJson(content, Customer[].class);
       assertTrue(customerlist.length > 0);
	}


}
