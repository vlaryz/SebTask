package com.example.sebtask.validators;

import com.example.sebtask.annotations.UniqueEmail;
import com.example.sebtask.annotations.UniqueTelNumber;
import com.example.sebtask.annotations.ValidDate;
import com.example.sebtask.services.CustomerService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class DateValidator implements
        ConstraintValidator<ValidDate, String> {

    private final CustomerService customerService;

    @Override
    public void initialize(ValidDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        return customerService.dateIsValid(date);
    }
}
