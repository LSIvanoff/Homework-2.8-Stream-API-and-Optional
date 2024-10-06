package com.skypro.HW8.service;

import com.skypro.HW8.employee.Employee;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employees = new HashMap<>(Map.of(
            "1",
            new Employee("Иван",
                    "Иванов",
                    1,
                    100000 ),


            "2",
            new Employee("Петр",
                    "Петров",
                    2,
                    200000 ),

            "3",
            new Employee("Василий",
                    "Васильев",
                    3,
                    131000),

            "4",
            new Employee("Виктор",
                    "Викторов",
                    3,
                    141000 ),

            "5",
            new Employee(" Ира",
                    "Год",
                    4,
                    145000 )
    ));
    String[] departments   = {
            "IT",
            "руководящий",
            "юридический",
            "отдел закупок",
            "финансовый",

    };
    Map<String,Integer> departmentsCodes = Map.of (
            "IT", 1,
            "руководящий", 1,
            "юридический",2,
            "отдел закупок",3,
            "финансовый",4
    );



    @Override
    public List <Employee>  getEmployeesByDepartmentMin(Integer departmentId) {

        return employees.values().stream()
                .filter(e -> e.getDepartmentId().contains(departmentId))
                .collect(Collectors.toList());

    }

    @Override
    public List <Employee>  getEmployeesByDepartmentMax(Integer departmentId) {

        return  employees.values().stream()
                .filter(e -> e.getDepartmentId().contains(departmentId))
                .collect(Collectors.toList());
//                .collect(Collectors.toList());

    }

    @Override
    public List <Employee>  getEmployeesByDepartment(Integer departmentId) {

        return employees.values().stream()
                .filter(e -> e.getDepartmentId().contains(departmentId))
                .collect(Collectors.toList());

    }



    @Override

    public Collection <Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }



    @Override

    public void addEmployees(Employee employee) {
        employees.put(employee.getDepartmentId().toString(), employee);
    }
}
