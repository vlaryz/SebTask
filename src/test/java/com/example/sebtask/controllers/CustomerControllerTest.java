package com.example.sebtask.controllers;

import com.example.sebtask.SebTaskApplication;
import com.example.sebtask.repositories.CustomerRepository;
import com.example.sebtask.services.CustomerService;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes=SebTaskApplication.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @MockBean
    private CustomerRepository repository;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void customerController_RequestAddCustomerWithInvalidName_ReturnsWrongNameMessage() throws Exception {
        String expectedResponse = "{\"name\":\"Incorrect name\"}";
        String request = "{" +
                "    \"name\": \"\"," +
                "    \"surname\": \"Surname\"," +
                "    \"birthDate\": \"2000-04-10\"," +
                "    \"telNumber\": \"+37016577748\"," +
                "    \"email\": \"name@gmail.com\"" +
                "}";
        this.mockMvc.perform(post("/api/customers/v1/addCustomer")
                        .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(content().json(expectedResponse));
    }

    @Test
    public void customerController_RequestAddCustomerWithInvalidSurname_ReturnsWrongSurnameMessage() throws Exception {
        String expectedResponse = "{\"surname\":\"Incorrect surname\"}";
        String request = "{" +
                "    \"name\": \"Name\"," +
                "    \"surname\": \"\"," +
                "    \"birthDate\": \"2000-04-10\"," +
                "    \"telNumber\": \"+37016577748\"," +
                "    \"email\": \"name@gmail.com\"" +
                "}";
        this.mockMvc.perform(post("/api/customers/v1/addCustomer")
                        .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(content().json(expectedResponse));
    }

    @Test
    public void customerController_RequestAddCustomerWithInvalidDate_ReturnsWrongDateMessage() throws Exception {
        String expectedResponse = "{\"birthDate\":\"Birth Date is incorrect. Must be \\\"yyyy-mm-dd\\\"\"}";
        String request = "{" +
                "    \"name\": \"Name\"," +
                "    \"surname\": \"Surname\"," +
                "    \"birthDate\": \"2000-04-0\"," +
                "    \"telNumber\": \"+37016577748\"," +
                "    \"email\": \"name@gmail.com\"" +
                "}";
        this.mockMvc.perform(post("/api/customers/v1/addCustomer")
                .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(content().json(expectedResponse));
    }

    @Test
    public void customerController_RequestAddCustomerWithInvalidTelNumber_ReturnsWrongTelNumberMessage() throws Exception {
        String expectedResponse = "{\"telNumber\":\"Phone Number is incorrect\"}";
        String request = "{" +
                "    \"name\": \"Name\"," +
                "    \"surname\": \"Surname\"," +
                "    \"birthDate\": \"2000-04-10\"," +
                "    \"telNumber\": \"1\"," +
                "    \"email\": \"name@gmail.com\"" +
                "}";
        this.mockMvc.perform(post("/api/customers/v1/addCustomer")
                        .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(content().json(expectedResponse));
    }

    @Test
    public void customerController_RequestAddCustomerWithInvalidEmail_ReturnsWrongEmailMessage() throws Exception {
        String expectedResponse = "{\"email\":\"Email format is not valid\"}";
        String request = "{" +
                "    \"name\": \"Name\"," +
                "    \"surname\": \"Surname\"," +
                "    \"birthDate\": \"2000-04-10\"," +
                "    \"telNumber\": \"+37016577748\"," +
                "    \"email\": \"namegmail.com\"" +
                "}";
        this.mockMvc.perform(post("/api/customers/v1/addCustomer")
                        .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(content().json(expectedResponse));
    }

    @Test
    public void customerController_RequestListCustomers_StatusOk() throws Exception {
        this.mockMvc.perform(get("/api/customers/v1/listCustomers").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }
}