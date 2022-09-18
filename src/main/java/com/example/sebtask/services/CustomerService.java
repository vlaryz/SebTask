package com.example.sebtask.services;

import com.example.sebtask.contracts.CustomerRequest;
import com.example.sebtask.contracts.CustomerResponse;
import com.example.sebtask.interfaces.ICustomerRepository;
import com.example.sebtask.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

//    public CustomerService(ICustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

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

    public boolean emailAlreadyExists(String email){
        return customerRepository.emailAlreadyExists(email);
    }

    public boolean telNumberAlreadyExists(String number){
        return customerRepository.phoneNumberAlreadyExists(number);
    }

    public boolean dateIsValid(String value) {
        if(value.equals(""))
            return false;
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null && date.before(new Date());
    }
}
