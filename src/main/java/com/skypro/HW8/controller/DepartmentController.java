package com.skypro.HW8.controller;

import com.skypro.HW8.employee.Employee;
import com.skypro.HW8.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam Integer departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable Integer departmentId) {
        return departmentService.getByDepartment(departmentId);
    }

    @GetMapping
    public Map<Integer, List<Employee>> getEmpByDepartment() {
        return departmentService.getEmpByDepartment();
    }
}
