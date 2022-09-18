package com.example.sebtask.annotations;

import com.example.sebtask.validators.UniqueEmailValidator;
import com.example.sebtask.validators.UniqueTelNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = UniqueTelNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTelNumber {
    String message() default "Phone Number is already is use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
