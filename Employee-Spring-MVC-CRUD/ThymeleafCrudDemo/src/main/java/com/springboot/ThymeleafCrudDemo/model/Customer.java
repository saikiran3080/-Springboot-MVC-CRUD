package com.springboot.ThymeleafCrudDemo.model;

import com.springboot.ThymeleafCrudDemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private  String firstName;

    @NotNull(message = " lastname can't be empty")
    @Size(min = 3, message = "atleast 3 characters should be there")
    private String lastName="";

    @Min(value = 0 ,message = "Age should greater be than 0")
    @Max(value = 100 , message = "Please enter age below 100")
    @NotNull(message = "age field is required")
    private Integer age;

    @NotNull(message = " emailcan't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" , message = "Please enter correct email format")
    private String email;

//    have provided default value & error message
    @CourseCode
    private String courseCode;



    public Customer()
    {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "can't be empty") @Size(min = 3, message = "atleast 3 characters should be there") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "can't be empty") @Size(min = 3, message = "atleast 3 characters should be there") String lastName) {
        this.lastName = lastName;
    }

    public @Min(value = 0, message = "Age should greater be than 0") @Max(value = 100, message = "Please enter age below 100") @NotNull(message = "age field is required") Integer getAge() {
        return age;
    }

    public void setAge(@Min(value = 0, message = "Age should greater be than 0") @Max(value = 100, message = "Please enter age below 100") @NotNull(message = "age field is required") Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
