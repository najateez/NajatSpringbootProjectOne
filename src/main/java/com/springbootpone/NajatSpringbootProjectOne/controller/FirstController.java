package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// to show output into the sceen. when you write in googlechrom : your api:8080. or localhost:8080
@RestController
public class FirstController {

    @Autowired
    StudentService studentservice;

    @GetMapping
    public void addStudent(){

        studentservice.addStudent();
    }


 /*   @GetMapping(name="hello")
    public String helloStudent(){

        return "hello studentssssz";
    } */


}
