package com.example.sebtask.validators;

import com.example.sebtask.annotations.UniqueEmail;
import com.example.sebtask.services.CustomerService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidator implements
        ConstraintValidator<UniqueEmail, String> {

    private final CustomerService customerService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !customerService.emailAlreadyExists(email);
    }
}
