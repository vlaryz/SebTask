package com.example.sebtask.annotations;

import com.example.sebtask.validators.DateValidator;
import com.example.sebtask.validators.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = DateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
    String message() default "Date is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}