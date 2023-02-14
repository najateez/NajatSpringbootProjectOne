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

/* to show output into the sceen. when you write in googlechrom : your ip:8080. or localhost:8080 .
  you can find your ip . cmd -> ipconfig -> IPv4 Address. . . . . . . . . . . : 192.168.100.69 .
 */
@RestController
public class FirstController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;
    @Autowired
    MarkService markService;


    // for fk.. school id in student table
    //exp: localhost:8080/student/getStudentsBySchoolName?schoolName=abc
   @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {

       return studentService.getStudentsBySchoolName(schoolName);
   }
    // for fk
    @RequestMapping(value = "course/getCourseByStudentName", method = RequestMethod.GET)
    public List<Course> getCourseByStudentName(@RequestParam String studentName) {

        return courseService.getCoursesByStudentName(studentName);
    }
    // for fk
    @RequestMapping(value = "mark/getMarksByCourseName", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseName(@RequestParam String courseName) {

        return markService.getMarkByCourseName(courseName);
    }





 /*   @GetMapping(name="hello")
    public String helloStudent(){

        return "hello studentssssz";
    } */


}
