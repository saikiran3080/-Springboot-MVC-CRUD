package com.springboot.ThymeleafCrudDemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//where you can apply
@Target({ElementType.METHOD ,ElementType.FIELD})
//Retain this annotation , process it to runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

//    define default course code
    public String value() default "CUR";

//    define default error message
    public String message() default "must start with 'CUR'";

//    define default groups
//    can group related constraints
    public  Class<?>[] groups() default{};


//    define default payloads
//    Payloads : provide custom details of validation provide (severity level , error code etc)
    public  Class<? extends Payload>[] payload() default {};


}
