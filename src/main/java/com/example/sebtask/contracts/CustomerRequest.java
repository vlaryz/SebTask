package com.example.sebtask.contracts;

import com.example.sebtask.annotations.UniqueEmail;
import com.example.sebtask.annotations.UniqueTelNumber;
import com.example.sebtask.annotations.ValidDate;
import com.example.sebtask.models.Customer;
import com.example.sebtask.services.CustomerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRequest {

   // @NotBlank(message = "Name not provided")
    @Size(min  = 3, message = "Incorrect name")
    @Size(max = 30, message = "Incorrect name")
    private String name;

    //@NotBlank(message = "Surname not provided")
    @Size(min  = 3, message = "Incorrect surname")
    @Size(max = 30, message = "Incorrect surname")
    private String surname;

    @NotNull(message = "Birth Date is incorrect. Must be \"yyyy-mm-dd\"")
    @ValidDate(message = "Birth Date is incorrect. Must be \"yyyy-mm-dd\"")
    private String birthDate;

    @NotBlank(message = "Phone number not provided")
    @Pattern(regexp="^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "Phone Number is incorrect")
    @UniqueTelNumber(message = "Phone number is already in use")
    private String telNumber;

    @NotBlank(message = "Email not provided")
    @Email(message = "Email format is not valid")
    @UniqueEmail(message = "Email is already in use")
    private String email;

    public Customer getCustomer() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Customer(name, surname, formatter.parse(birthDate), telNumber, email);
        } catch (ParseException e) {
            e.printStackTrace();
           return null;
        }
    }

    public CustomerRequest(Customer customer) {
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").format(customer.getBirthDate());
        this.telNumber = customer.getTelNumber();
        this.email = customer.getEmail();
    }
}
