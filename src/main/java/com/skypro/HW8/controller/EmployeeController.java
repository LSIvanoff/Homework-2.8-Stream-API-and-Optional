package com.skypro.HW8.controller;

import com.skypro.HW8.employee.Employee;
import com.skypro.HW8.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController

public class EmployeeController {
    private final  EmployeeService employeeService;



    public EmployeeController(
            EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("name") String name,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("departmentId") Integer departmentId,
                              @RequestParam("salary") Integer salary
    ) {

        Employee employee = new Employee(
                name,
                lastName,
                departmentId,
                salary
        );
        employeeService.addEmployees(employee);
        return "Employee added";
    }

    @GetMapping(path = "/departments/min-salary")
    public String getByDepartmentsMinSalary(@RequestParam("departmentId") int departmentId) {
        final List<Employee> employeesByDepartmentMin= employeeService.getEmployeesByDepartmentMin(departmentId);



        final Optional <String> employeeWithMinSalary = employeesByDepartmentMin.stream()


                .min(Comparator.comparingInt(Employee::getSalary   ))
                .map(p -> "~`" + p + "~")
                .filter(p->p.startsWith("1"))

                ;

        return employeeWithMinSalary.orElseThrow(() ->new RuntimeException("Employee not found"));


    }

    @GetMapping(path = "/departments/max-salary")
    public String getByDepartmentsMaxSalary(@RequestParam("departmentId") int departmentId) {
        final List<Employee> employeesByDepartment= employeeService.getEmployeesByDepartmentMax(departmentId);



        final Optional <String> employeeWithMaxSalary = employeesByDepartment.stream()


                .min(Comparator.comparingInt(Employee::getSalary))
                .map(p -> "~`" + p + "~")


                .filter(p->p.startsWith("1"))
                ;

        return employeeWithMaxSalary.orElseThrow(() ->new RuntimeException("Employee not found"));


    }


    @GetMapping(path = "/department/all")
    public String getByDepartments(@RequestParam("departmentId") int departmentId) {
        final List<Employee> employeesByDepartment = employeeService.getEmployeesByDepartment(departmentId);

        final Optional <String> employeesDepartment = employeesByDepartment.stream()
                .map(e -> e.getFullName())

                .map(p -> "~`" + p + "~")

                .findAny()
                ;

        return employeesDepartment.orElseThrow(() ->new RuntimeException("Employee not found"));


    }

    @GetMapping("/departments/all ")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAll();
    }
}
