package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Services.CourseService;
import com.springbootpone.NajatSpringbootProjectOne.Services.MarkService;
import com.springbootpone.NajatSpringbootProjectOne.Services.SchoolService;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// to show output into the sceen. when you write in googlechrom : your api:8080. or localhost:8080
@RestController
public class FirstController {

    @Autowired
    StudentService studentService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    CourseService courseService;

    @Autowired
    MarkService markService;


    public void addStudent(){

        studentService.addStudent();
    }
    /* must be one @GetMapping to put , just for table that you want to insert values. can not write above
     all functions, it will show errors during run time.
     */
    @GetMapping
    public void addSchool(){

        schoolService.addSchool();
    }

    public void addCourse(){

        courseService.addCourse();
    }


    public void addMark(){

        markService.addMark();
    }

    //to show data which is added in table into screen in localhost and postman
    @RequestMapping(value="school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return schools;
    }

    @RequestMapping(value="student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student> theStudent = studentService.getAllStudents();
        return theStudent;
    }

    @RequestMapping(value="course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses(){
        List<Course> theCourse = courseService.getAllCourses();
        return theCourse;
    }

    @RequestMapping(value="mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks(){
        List<Mark> theMark = markService.getAllMarks();
        return theMark;
    }

    @GetMapping(value = "school/deleteById")
    public String deleteSchoolById(@RequestParam Integer id){

        schoolService.deleteSchoolById(id);
        return "Record of school table deleted successfully";
    }

    @GetMapping(value = "student/deleteById")
    public String deleteStudentById(@RequestParam Integer id){

        studentService.deleteStudentById(id);
        return "Record of student table deleted successfully";
    }

    @GetMapping(value = "course/deleteById")
    public String deleteCourseById(@RequestParam Integer id){

        courseService.deleteCourseById(id);
        return "Record of course table deleted successfully";
    }

    @GetMapping(value = "mark/deleteById")
    public String deleteMarkById(@RequestParam Integer id){

        markService.deleteMarkById(id);
        return "Record of mark table deleted successfully";
    }






















 /*   @GetMapping(name="hello")
    public String helloStudent(){

        return "hello studentssssz";
    } */


}
