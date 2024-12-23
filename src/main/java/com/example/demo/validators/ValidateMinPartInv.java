package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateMinPartInv implements ConstraintValidator<ValidMinPartInv, Part> {

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {

        return part.getInv() >= part.getMin();
    }
}