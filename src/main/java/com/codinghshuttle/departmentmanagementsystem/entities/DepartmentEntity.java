package com.codinghshuttle.departmentmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String email;
    private LocalDate createdAt;
    private String creditCardNumber;
    private String password;
    private Integer primeNumber;
    private Boolean isActive;
}
