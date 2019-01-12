package com.example.demo.springrestjpa.controller;

import com.example.demo.springrestjpa.domain.Address;
import com.example.demo.springrestjpa.domain.Customer;
import com.example.demo.springrestjpa.domain.Name;
import com.example.demo.springrestjpa.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * CustomerControllerTest
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private CustomerService customerService;

    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
     }

    @Test
    public void getCustomerById_Test() throws Exception {

        Customer mockCustomer = new Customer(3L, new Name("Rajeep", "P", "Palkar"), "RP", "Mr.", new Address("393A", "Orange Grove", "Blackwall", "NSW", "Australia", "2256"), "Male", "Single", 85L, true);

        Mockito.when(customerService.getCustomerById(Mockito.anyLong()))
        .thenReturn(mockCustomer);

        RequestBuilder builder = MockMvcRequestBuilders.get("/api/customer/3").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        String expectedJson = this.mapToJson(mockCustomer);
        String outputInJson = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedJson, outputInJson);
    }

    @Test
    public void createNewCustomer_Test() throws Exception {
        Customer mockCustomer = new Customer(3L, new Name("Rajeep", "P", "Palkar"), "RP", "Mr.", new Address("393A", "Orange Grove", "Blackwall", "NSW", "Australia", "2256"), "Male", "Single", 85L, true);

        String inputInJson = this.mapToJson(mockCustomer);

        Mockito.when(customerService.createNewCustomer(Mockito.any(Customer.class)))
        .thenReturn(mockCustomer);
        RequestBuilder builder = MockMvcRequestBuilders.post("/api/customer/save").accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputInJson = response.getContentAsString();

        assertEquals(outputInJson,inputInJson);
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void deleteCustomer_Test() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.delete("/api/customer/delete/3").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Customer with ID: " + 3 + " was deleted");
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    
}