package com.codinghshuttle.departmentmanagementsystem.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {DepartmentPrimeNumberValidator.class})
public @interface DepartmentPrimeNumberValidation {

    String message() default "The prime number field cannot be non prime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
