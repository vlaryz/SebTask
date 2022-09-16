package com.example.sebtask.interfaces;

import com.example.sebtask.models.Customer;

import java.util.List;

public interface ICustomerRepository {

    Customer addCustomer(Customer customer);

    List<Customer> listCustomers();
}
