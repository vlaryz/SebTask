package com.example.sebtask.controllers;

import com.example.sebtask.contracts.CustomerRequest;
import com.example.sebtask.contracts.CustomerResponse;
import com.example.sebtask.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/customers/v1")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @CrossOrigin
    @PostMapping(value = "/addCustomer")
    public CustomerResponse addCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.addCustomer(customerRequest);
    }

    @CrossOrigin
    @GetMapping("/listCustomers")
    public List<CustomerResponse> listCustomers() {
        return customerService.listCustomers();
    }
}
