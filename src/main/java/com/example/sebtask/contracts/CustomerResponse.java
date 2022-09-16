package com.example.sebtask.contracts;

import com.example.sebtask.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String name;
    private String surname;
    private String birthDate;
    private String telNumber;
    private String email;

    public static CustomerResponse fromCustomer (Customer customer){
        return new CustomerResponse(customer.getName(), customer.getSurname(),
                new SimpleDateFormat("yyyy-MM-dd").format(customer.getBirthDate()), customer.getTelNumber(), customer.getEmail());
    }
}
