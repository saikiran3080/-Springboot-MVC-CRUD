package com.springboot.ThymeleafCrudDemo.controller;

import com.springboot.ThymeleafCrudDemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/valid-demo")
public class CustomerController {

//    add initbinder to trim input string
//    remove leading and trailing whitespace
//    resolve issue for validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
//        StringTimmerEdiotr : defined in SPRING API
//        true : Trime down to NULL
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class , stringTrimmerEditor);
    }


    @GetMapping("/showForm")
    public String showForm(Model theModel)
    {
        theModel.addAttribute("customer",new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer ,
                              BindingResult theBindingresult)
    {
        if(theBindingresult.hasErrors())
        {
            return "customer-form";
        }

        return "customer-conf";

    }
}
