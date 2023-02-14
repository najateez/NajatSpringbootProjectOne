package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SchoolController {

    /* After using extends of (BaseEntity class), we create for each class seperate controller. and all codes
      which is related to school will be here. student to student. course to course. mark to mark. but combination
      between 2 classes as fk , should be in FirstController.
     */

    @Autowired
    SchoolService schoolService;

    // for inserting : exp : localhost:8080
    @GetMapping
    public void addSchool() {

        schoolService.addSchool();
    }

    /* must be one @GetMapping to put , just for table that you want to insert values. can not write above
     all functions, it will show errors during run time.
     */

    /* - when you want to insert any value in any table just put notation @GetMapping above that add function
    and it will insert values of that table.  ONLY one table can insert value at a time.  (for ONE TABLE).
     */

    //to show data which is added in table into screen in localhost and postman
    //exp: localhost:8080/school/getAll
    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return schools;
    }

    //exp: localhost:8080/school/deleteById?id=7
    @GetMapping(value = "school/deleteById")
    public String deleteSchoolById(@RequestParam Integer id) {

        schoolService.deleteSchoolById(id);
        return "Record of school table deleted successfully";
    }

    //getById :-
    //exp: localhost:8080/school/getById?schoolId=2  . coulmnName = depend on what you write in sqlQuery , user input.
    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId){
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    //getByColumnName:-
    // exp : localhost:8080/school/getByColumnSchoolName?schoolName=abc .   SchoolName ->that user input
    @RequestMapping(value = "school/getByColumnSchoolName", method = RequestMethod.GET)
    public School getSchoolBySchoolName(@RequestParam String schoolName){
        School school = schoolService.getSchoolBySchoolName(schoolName);
        return school;
    }
}