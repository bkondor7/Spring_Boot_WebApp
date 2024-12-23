package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidateMinPartInv.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMinPartInv {

    String message() default "Inventory must be above minimum limit";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}