package com.example.sebtask.interfaces;

import com.example.sebtask.contracts.CustomerRequest;
import com.example.sebtask.contracts.CustomerResponse;

import java.util.List;

public interface ICustomerService {

    CustomerResponse addCustomer(CustomerRequest customer);

    List<CustomerResponse> listCustomers();
}
