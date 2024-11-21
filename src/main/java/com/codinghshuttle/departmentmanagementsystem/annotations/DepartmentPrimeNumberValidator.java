package com.codinghshuttle.departmentmanagementsystem.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentPrimeNumberValidator implements ConstraintValidator<DepartmentPrimeNumberValidation,Integer> {

    @Override
    public boolean isValid(Integer inputNumber, ConstraintValidatorContext constraintValidatorContext) {

        if(inputNumber==null) return false;
        return isPrime(inputNumber);
    }

    private boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
