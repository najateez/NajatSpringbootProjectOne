package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Component
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

    // getAllNotActiveStudents :-
    @RequestMapping(value = "getAllStudentsByIsActiveFalse")
    public List<Student> getAllInActiveStudents() {
        List<Student> notActiveStudentsList = studentService.getAllInActiveStudents();
        return notActiveStudentsList;
    }

    //deleteStudentByColumnNameStudentName :-
    @GetMapping(value = "student/deleteByColumnNameStudentName")
    public String deleteStudentByColumnNameStudentName(@RequestParam String name) {

        studentService.deleteStudentByColumnNameStudentName(name);
        return "Record of school table deleted successfully";
    }

    //updateCreatedDateByUserInputForStudent :-
    @RequestMapping(value = "student/updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        studentService.setCreatedDateByUserInput(date, id);
    }

    //deleteById--> they mean  MakeIsActiveFalseBySchoolId
    @RequestMapping(value = "deleteStudentByIdIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseByStudentId(@RequestParam Integer studentId) {
        studentService.getPutIsActiveFalseByStudentId(studentId);
    }

    //deleteByColumnName--> they mean  MakeIsActiveFalseByStudentName
    @RequestMapping(value = "student/deleteByStudentNameIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseByStudentName(@RequestParam String studentName) {
        studentService.getPutIsActiveFalseByStudentName(studentName);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllStudents
    //exp: localhost:8080/student/deleteByAllPutIsActiveFalseByStudentForAll
    @RequestMapping(value = "student/deleteByAllPutIsActiveFalseByStudentForAll", method = RequestMethod.POST)
    public void getPutIsActiveFalseForAllStudents() {
        studentService.getPutIsActiveFalseForAllStudents();
    }

    //updateSchool :-
    //exp: localhost:8080/student/updateStudent?studentName=aweeehah&studentId=18
    @RequestMapping(value = "student/updateStudent", method = RequestMethod.POST)
    public void getUpdateStudentById(@RequestParam Integer studentId, @RequestParam String studentName) {
        studentService.getUpdateStudentById(studentId,studentName);
    }

    //getLatestRow
    // exp: localhost:8080/student/getLatestRowStudent
    @RequestMapping(value = "student/getLatestRowStudent")
    public Student getLatestRowStudent() {
        Student student = studentService.getLatestRowStudent();
        return student;
    }

    //getLatestUpdated
    @RequestMapping(value = "student/getLatestUpdatedStudent", method = RequestMethod.GET)
    public Student getLatestUpdatedStudent() {
        Student student = studentService.getLatestUpdatedStudent();
        return student;
    }

    //getCreatedAfterDate
    @RequestMapping(value = "student/getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getCreatedAfterDateStudent(@RequestParam String createdDate) throws ParseException {
        List<Student> createdAfterDate = studentService.getCreatedAfterDateStudent(createdDate);
        return createdAfterDate;
    }

    //UpdateIsActiveTrueByStudentId
    @RequestMapping(value = "student/updateIsActiveToTrueByStudentId", method = RequestMethod.POST)
    public void getUpdateIsActiveTrueByStudentId(@RequestParam Integer studentId) {
        studentService.getUpdateIsActiveTrueByStudentId(studentId);
    }

    //updateUpdatedDateByUserInputForStudent :-
    @RequestMapping(value = "student/updateUpdatedDateByUserInput")
    public void setUpdateUpdatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        studentService.setUpdateUpdatedDateByUserInput(date, id);
    }

    //addNewSchoolDependOfStudentInput
    //exp: localhost:8080/school/addNewSchoolDependOfSchoolInput?schoolName=twixxxia&isActive=true
    //used SchoolService, schoolController.
    //same as previous code of addSchool() but with parameter.
    @RequestMapping(value = "student/addNewStudentDependOfStudentInput", method = RequestMethod.POST)
    public void addNewStudentDependOfStudentInput(@RequestParam String studentName, @RequestParam String rollNumber, @RequestParam Boolean isActive) {

        studentService.addNewStudentDependOfStudentInput(studentName,rollNumber,isActive);
    }

    //getStudentByCreatedDate :-
    //exp: localhost:8080/student/getStudentByCreatedDate?createdDate=2009-05-02 00:00:00.0000000
    //note: always date we will convert it to string, with parseException
    @RequestMapping(value = "student/getStudentByCreatedDate", method = RequestMethod.GET)
    public List<Student> getStudentByCreatedDate(@RequestParam String createdDate) throws ParseException {
        List<Student> student = studentService.getStudentByCreatedDate(createdDate);
        return student;
    }

    //deleteStudentByCreatedDate -> put isActive false by createdDate :-
    //exp: localhost:8080/student/UpdateIsActiveFalseByCreatedDate?createdDate=1996-12-12 00:00:00.0000000
    @RequestMapping(value = "student/UpdateIsActiveFalseByCreatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByCreatedDate(@RequestParam String createdDate) throws ParseException{
        studentService.getUpdateIsActiveFalseByCreatedDate(createdDate);
    }

    //getStudentByUpdatedDate
    //exp: localhost:8080/student/getStudentByUpdatedDate?updatedDate=2023-03-13
    //to work this code should time be in db all zero's.
    @RequestMapping(value = "student/getStudentByUpdatedDate", method = RequestMethod.GET)
    public List<Student> getStudentByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        List<Student> student = studentService.getStudentByUpdatedDate(updatedDate);
        return student;
    }

    //deleteStudentsByUpdatedDate -> put isActive false by UpdatedDate :-
    //exp: localhost:8080/student/UpdateIsActiveFalseByUpdatedDate?updatedDate=2023-03-19 00:00:00.0000000
    // to work this one should time be in db all zero's.
    @RequestMapping(value = "student/UpdateIsActiveFalseByUpdatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        studentService.getUpdateIsActiveFalseByUpdatedDate(updatedDate);
    }

    //deleteAllStudentsCreatedAfterDate -> put isActive false for AllStudentsCreatedAfterDate
    //exp: localhost:8080/school/deleteAllSchoolsCreatedAfterDate?createdDate=1111-12-12
    // to work this one should time be in db all zero's.
    @RequestMapping(value = "student/deleteAllStudentsCreatedAfterDate", method = RequestMethod.POST)
    public void getDeleteAllStudentsCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        studentService.getDeleteAllStudentsCreatedAfterDate(createdDate);

    }








}
