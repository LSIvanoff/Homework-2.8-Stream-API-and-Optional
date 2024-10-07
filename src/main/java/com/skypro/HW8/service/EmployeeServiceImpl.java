package com.skypro.HW8.service;

import com.skypro.HW8.employee.Employee;
import com.skypro.HW8.exception.EmployeeAlreadyAddedException;
import com.skypro.HW8.exception.EmployeeNotFoundException;
import com.skypro.HW8.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int LIST_SIZE = 10;

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Adam", "Adamov", 2000, 1),
            new Employee("Boris", "Borisov", 1000, 1),
            new Employee("Vladimir", "Vladimirov", 3000, 2),
            new Employee("Gavril", "Gavriliev", 5000, 2),
            new Employee("Dmitry", "Dmitriev", 4000, 2),
            new Employee("Egor", "Egorov", 10000, 3),
            new Employee("Zachar", "Zacharov", 10000, 3),
            new Employee("Ivan", "Ivanov", 10000, 3)));


    @Override
    public Employee add(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= LIST_SIZE) {
            throw new EmployeeStorageIsFullException("The list size is exceeded!!!");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Such an employee already exists!!!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("This employee has not been found");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("This employee has not been found");
    }

    @Override
    public List<Employee> getAll() {
        return employees;

    }
}
