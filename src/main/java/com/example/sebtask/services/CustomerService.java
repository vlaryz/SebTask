package com.example.sebtask.services;

import com.example.sebtask.contracts.CustomerRequest;
import com.example.sebtask.contracts.CustomerResponse;
import com.example.sebtask.interfaces.ICustomerRepository;
import com.example.sebtask.interfaces.ICustomerService;
import com.example.sebtask.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse addCustomer(CustomerRequest customer) {
        return CustomerResponse.fromCustomer(customerRepository.addCustomer(customer.getCustomer()));
    }

    @Override
    public List<CustomerResponse> listCustomers() {
        var customers = customerRepository.listCustomers();
        return customers.stream().map(CustomerResponse::fromCustomer).peek(item -> {
        }).collect(Collectors.toList());
    }
}
