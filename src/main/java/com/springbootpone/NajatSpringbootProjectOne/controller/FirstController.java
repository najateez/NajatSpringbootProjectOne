package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Services.SchoolService;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// to show output into the sceen. when you write in googlechrom : your api:8080. or localhost:8080
@RestController
public class FirstController {

    @Autowired
    StudentService studentservice;

    @Autowired
    SchoolService schoolservice;

    @GetMapping
    public void addStudent(){
        studentservice.addStudent();
    }

    @RequestMapping(value="school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools(){
        List<School> schools = schoolservice.getAllSchools();
        return schools;
    }













 /*   @GetMapping
    public void addStudent(){

        studentservice.addStudent();
    }  */


 /*   @GetMapping(name="hello")
    public String helloStudent(){

        return "hello studentssssz";
    } */


}
