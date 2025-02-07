package com.springboot.ThymeleafCrudDemo.service;

import com.springboot.ThymeleafCrudDemo.dao.EmployeeRepository;
import com.springboot.ThymeleafCrudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    //    Optional : is a different pattern instead of checking for null
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee= null;

        if(result.isPresent())
        {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Couldn't find Employee id: "+theId);
        }

        return theEmployee;
    }

//    @Transactional
    @Override
    public Employee save(Employee theEmployees) {
        return employeeRepository.save(theEmployees);
    }

//    @Transactional
//    @Transactional : can remove Spring DATA JPA handles transaction
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}

