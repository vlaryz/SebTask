package com.example.sebtask.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
    private long id;
    private String name;
    private String surname;
    private Date birthDate;
    private String telNumber;
    private String email;

    public Customer(String name, String surname, Date birthDate, String telNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.telNumber = telNumber;
        this.email = email;
    }
}
