package com.springboot.ThymeleafCrudDemo.service;

import com.springboot.ThymeleafCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
