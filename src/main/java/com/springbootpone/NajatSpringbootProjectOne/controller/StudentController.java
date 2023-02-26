package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController
public class StudentController {

    @Autowired // it is as define object. exp: StudentService studentService= new StudentService studentService(); . instead of using this, use @Autowired .
    StudentService studentService;

    @GetMapping
    public void addStudent(){

        studentService.addStudent();
    }

    @RequestMapping(value="student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student> theStudent = studentService.getAllStudents();
        return theStudent;
    }

    @GetMapping(value = "student/deleteById")
    public String deleteStudentById(@RequestParam Integer id){

        studentService.deleteStudentById(id);
        return "Record of student table deleted successfully";
    }

    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId){
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @RequestMapping(value = "student/getByColumnStudentName", method = RequestMethod.GET)
    public Student getStudentByStudentName(@RequestParam String studentName){
        Student student = studentService.getStudentByStudentName(studentName);
        return student;
    }

    // getAllActiveStudents :-
    @RequestMapping(value = "getAllStudentsByIsActive")
    public List<Student> getAllActiveStudents() {
        List<Student> activeStudentsList = studentService.getAllActiveStudents();
        return activeStudentsList;
    }




}
