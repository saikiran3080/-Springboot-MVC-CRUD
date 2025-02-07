package com.springboot.ThymeleafCrudDemo.dao;

import com.springboot.ThymeleafCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    that's it no need to write any implementation like (DAO interface & its implementation)
//    just use in place EmployeeeDao , by EmployeeRepository as Spring Data JPA Repository

//    add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
//    spring data jpa will parse the method name look for specific format and pattern
//    Create appropriate query behind the scene

}
