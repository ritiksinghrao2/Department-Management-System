package com.codinghshuttle.departmentmanagementsystem.dto;

import com.codinghshuttle.departmentmanagementsystem.annotations.DepartmentPasswordValidation;
import com.codinghshuttle.departmentmanagementsystem.annotations.DepartmentPrimeNumberValidation;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeparmentDTO {

    private Long Id;

    @NotEmpty(message = "Title of the department cannot be empty")
    @Size(min = 3, max = 20, message = "Numbers of characters in the title should be in range: [3,20]")
    private String title;

    @NotBlank(message = "Email of the department cannot be blank")
    @Email(message = "Email should be valid email")
    private String email;

    @PastOrPresent(message = "createdAt field in Department cannot be in future")
    private LocalDate createdAt;

    @CreditCardNumber
    private String creditCardNumber;

    @DepartmentPasswordValidation
    private String password;

    @DepartmentPrimeNumberValidation
    private Integer primeNumber;

    @AssertTrue(message = "isActive should be true by default")
    private Boolean isActive;

}
