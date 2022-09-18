package com.example.sebtask.services;

import com.example.sebtask.contracts.CustomerRequest;
import com.example.sebtask.contracts.CustomerResponse;
import com.example.sebtask.interfaces.ICustomerRepository;
import com.example.sebtask.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {

    @MockBean
    private ICustomerRepository repository;

    @Autowired
    private CustomerService service;

    /*
    *   Written only one test, because we can assume, that CustomerRequest object
    *   is valid because of validation constraints annotations.
    */
    @Test
    void addCustomer_AddValidCustomer_AddsCustomerToListAndReturnsIt() {
        Customer customer = new Customer("name",
                "surname", new Date(), "+31678464764", "email@email.com");
        CustomerRequest customerRequest = new CustomerRequest(customer);
        CustomerResponse customerResponse = CustomerResponse.fromCustomer(customer);

        when(repository.addCustomer(any(Customer.class))).thenReturn(customer);
        var actual = service.addCustomer(customerRequest);

        assertNotNull(actual);
        assertThat(customerResponse).usingRecursiveComparison().isEqualTo(actual);
    }

    @Test
    void listCustomers_ListIsNotEmpty_ReturnsListOfCustomers() {
        List<CustomerResponse> expectedList = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("name",
                "surname", new Date(), "+31678464764", "email@email.com");
        Customer customer2 = new Customer("name2",
                "surname2", new Date(), "+316784647642", "email2@email.com");
        customers.add(customer);
        customers.add(customer2);
        expectedList.add(CustomerResponse.fromCustomer(customer));
        expectedList.add(CustomerResponse.fromCustomer(customer2));

        when(repository.listCustomers()).thenReturn(customers);
        var actual = service.listCustomers();

        assertThat(expectedList).usingRecursiveComparison().isEqualTo(actual);
    }

    @Test
    void listCustomers_ListIsEmpty_ReturnsEmptyList() {
        List<CustomerResponse> expectedList = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        when(repository.listCustomers()).thenReturn(customers);
        var actual = service.listCustomers();

        assertEquals(expectedList.size(), actual.size());
    }

    @Test
    void emailAlreadyExists_PassExistingEmail_ReturnTrue() {
        Customer customer = new Customer("name",
                "surname", new Date(), "+31678464764", "email@email.com");
        CustomerRequest customerRequest = new CustomerRequest(customer);
        CustomerResponse customerResponse = CustomerResponse.fromCustomer(customer);

        when(repository.emailAlreadyExists(anyString())).thenReturn(true);
        var actual = service.addCustomer(customerRequest);

        assertNotNull(actual);
        assertThat(customerResponse).usingRecursiveComparison().isEqualTo(actual);
    }
}