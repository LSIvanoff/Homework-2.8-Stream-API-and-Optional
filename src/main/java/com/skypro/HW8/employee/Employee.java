package com.skypro.HW8.employee;

import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {

    private final String name;
    private final String lastName;
    private final  Set<Integer> departmentId;
    private final  Integer salary;

    public Employee(String name, String lastName, int departmentId, Integer salary) {

        this.name = name;
        this.lastName = lastName;
        this.departmentId = new HashSet<>(List.of(departmentId));
        this.salary = salary;

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public String getFullName() {

        return name + "  " + lastName + "  ";

    }



    public Set<Integer> getDepartmentId() {
        return departmentId;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getFullName(), employee.getFullName()) && Objects.equals(getDepartmentId(), employee.getDepartmentId()) && Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getFullName(), getDepartmentId(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary='" + salary + '\'' +
                '}';
    }
}
