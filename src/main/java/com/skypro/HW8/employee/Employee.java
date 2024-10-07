package com.skypro.HW8.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {

    private final String firstName;
    private final String lastName;
    private double salary;
    private int department;


    public String getFio() {
        return firstName + " " + lastName;
    }

}
