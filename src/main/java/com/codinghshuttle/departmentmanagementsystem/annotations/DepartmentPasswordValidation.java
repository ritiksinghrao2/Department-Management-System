package com.codinghshuttle.departmentmanagementsystem.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {DepartmentPasswordValidator.class})
public @interface DepartmentPasswordValidation {

    String message() default "Password Should be contains at least one digit [0-9], one uppercase letter,one lowercase letter, one " +
            "special character, minimum length is 10 and maximum length is 20";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
