package com.example.sebtask.repositories;

import com.example.sebtask.interfaces.ICustomerRepository;
import com.example.sebtask.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Customer addCustomer(Customer customer) {
        customer.setId(customers.stream()
                .mapToLong(Customer::getId)
                .max()
                .orElse(- 1) + 1);

        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> listCustomers() {
        return customers;
    }

    public boolean emailAlreadyExists(String email){
        return customers.stream().filter(o -> o.getEmail().equals(email)).findFirst().isPresent();
    }

    public boolean phoneNumberAlreadyExists(String number) {
        return customers.stream().filter(o -> o.getTelNumber().equals(number)).findFirst().isPresent();
    }
}
