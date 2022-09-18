package com.example.sebtask.validators;

import com.example.sebtask.annotations.UniqueEmail;
import com.example.sebtask.annotations.UniqueTelNumber;
import com.example.sebtask.services.CustomerService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueTelNumberValidator implements
        ConstraintValidator<UniqueTelNumber, String> {

    private final CustomerService customerService;

    @Override
    public void initialize(UniqueTelNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        return !customerService.telNumberAlreadyExists(number);
    }
}

