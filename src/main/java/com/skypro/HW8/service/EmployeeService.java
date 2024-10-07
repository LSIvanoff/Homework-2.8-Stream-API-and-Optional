package com.skypro.HW8.service;

import com.skypro.HW8.employee.Employee;
import com.skypro.HW8.exception.EmployeeAlreadyAddedException;
import com.skypro.HW8.exception.EmployeeNotFoundException;
import com.skypro.HW8.exception.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee remove(String firstName, String lastName)
            throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName)
            throws EmployeeNotFoundException;

    List<Employee> getAll();

}
