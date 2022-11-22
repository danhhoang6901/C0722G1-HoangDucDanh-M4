package com.codegym.repository.impl;

import com.codegym.model.Employee;
import com.codegym.repository.IEmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "Danh", "01234"));
        employees.add(new Employee(2, "Danh2", "01234"));
        employees.add(new Employee(3, "Danh3", "01234"));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
