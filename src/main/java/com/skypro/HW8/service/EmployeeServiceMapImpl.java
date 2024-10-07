package com.skypro.HW8.service;

import com.skypro.HW8.employee.Employee;
import com.skypro.HW8.exception.EmployeeAlreadyAddedException;
import com.skypro.HW8.exception.EmployeeNotFoundException;
import com.skypro.HW8.exception.EmployeeStorageIsFullException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class EmployeeServiceMapImpl implements EmployeeService {

    private final int LIST_SIZE = 10;

    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Adam Adamov", new Employee("Adam", "Adamov", 2000, 1),
            "Boris Borisov", new Employee("Boris", "Borisov", 1000, 1),
            "Vladimir Vladimirov", new Employee("Vladimir", "Vladimirov", 3000, 2),
            "Gavril Gavriliev", new Employee("Gavril", "Gavriliev", 5000, 2),
            "Dmitry Dmitriev", new Employee("Dmitry", "Dmitriev", 4000, 2),
            "Egor Egorov", new Employee("Egor", "Egorov", 10000, 3),
            "Zachar Zacharov", new Employee("Zachar", "Zacharov", 10000, 3),
            "Ivan Ivanov", new Employee("Ivan", "Ivanov", 10000, 3)
    ));


    @Override
    public Employee add(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= LIST_SIZE) {
            throw new EmployeeStorageIsFullException("The list size is exceeded!!!");
        }
        if (employees.containsKey(keyGen(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException("Such an employee already exists!!!");
        }
        employees.put(keyGen(firstName, lastName), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFio())) {
            throw new EmployeeNotFoundException("This employee has not been found");
        }
        employees.remove(employee.getFio());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFio())) {
            return employee;
        }
        throw new EmployeeNotFoundException("This employee has not been found");
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    private String keyGen(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
