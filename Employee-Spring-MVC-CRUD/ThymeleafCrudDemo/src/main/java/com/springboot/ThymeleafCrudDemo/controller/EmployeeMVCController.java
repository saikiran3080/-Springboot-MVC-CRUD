package com.springboot.ThymeleafCrudDemo.controller;

import com.springboot.ThymeleafCrudDemo.entity.Employee;
import com.springboot.ThymeleafCrudDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeMVCController {

    private final EmployeeService employeeService;

    public  EmployeeMVCController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model theModel)
    {
//        get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

//        add to the model
        theModel.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }


    @GetMapping("/showFormForAdd")
    public String formForAddEmployee(Model theModel)
    {
//        create the model attribute to bind the form data
        Employee theEmployee = new Employee();

//        our thymeleaf template will access this data for binding form data
        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId ,Model theModel)
    {
//        get employee from the service
        Employee theEmployee = employeeService.findById(theId);

//        set employee to the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);

//        send over to our form
        return "employees/employee-form";

//        when the form is loaded initially in which i am sending data , will call get methods :-> employee.getFirstName();
//        call getter methods to prepopulate form fields initially
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
//        save the employee
        employeeService.save(theEmployee);

//        use redirect to avoid duplicate submission
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId)
    {
//        delete the employee
        employeeService.deleteById(theId);
//        redirect the employee/list
        return "redirect:/employees/list";
    }

}
