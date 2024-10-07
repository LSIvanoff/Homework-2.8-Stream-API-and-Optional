package com.skypro.HW8.service;

import com.skypro.HW8.employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(Integer departmentId);

    Employee minSalary(Integer departmentId);

    List<Employee> getByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> getEmpByDepartment();
}
