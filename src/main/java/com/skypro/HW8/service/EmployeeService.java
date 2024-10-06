package com.skypro.HW8.service;

import com.skypro.HW8.employee.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeesByDepartmentMax(Integer departmentId);

    List <Employee>  getEmployeesByDepartmentMin(Integer departmentId);

    List <Employee>  getEmployeesByDepartment(Integer departmentId);



    Collection<Employee> getAll();

    void addEmployees(Employee employee);

}
