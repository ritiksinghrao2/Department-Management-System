package com.codinghshuttle.departmentmanagementsystem.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepartmentPasswordValidator implements ConstraintValidator<DepartmentPasswordValidation,String> {
    @Override
    public boolean isValid(String inputPassword, ConstraintValidatorContext constraintValidatorContext) {
        return isValidPassword(inputPassword);
    }

    private boolean isValidPassword(String inputPassword){
        String PASSWORD_PATTERN =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

        Matcher matcher = pattern.matcher(inputPassword);
        return matcher.matches();
    }
}
