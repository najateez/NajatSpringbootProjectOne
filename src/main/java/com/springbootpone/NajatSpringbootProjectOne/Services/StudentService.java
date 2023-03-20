package com.springbootpone.NajatSpringbootProjectOne.Services;


import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service   //this will be my service
public class StudentService {

    // every function called bean
    @Autowired   // it is dependancy injection
    StudentRepository studentRepository;

    @Autowired   // for fk
    SchoolRepository schoolRepository;

   public void addStudent(){

        Student studentObj=new Student();
        studentObj.setName("jannat");
        studentObj.setRollNumber("3435");
        studentRepository.save(studentObj);
    }

    public List<Student> getAllStudents() {

        return studentRepository.getAllStudents();
    }

    public void deleteStudentById(Integer id){
        Student studentToDelete = studentRepository.findById(id).get();
        studentRepository.delete(studentToDelete);
    }

    // getById :-
    public Student getStudentById(Integer id){
        Student student = studentRepository.getStudentById(id);
        return student;
    }

    // getByColumnName :-
    public Student getStudentByStudentName(String name) {
        Student student = studentRepository.getStudentByStudentName(name);
        return student;
    }

    // for fk ... school id in student table

   public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolRepository.getSchoolBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;
    }

    // getAllActiveSchools :-
    public List<Student> getAllActiveStudents(){

        return studentRepository.getAllActiveStudents();
    }

    // getAllNotActiveStudents :-
    public List<Student> getAllInActiveStudents(){

        return studentRepository.getAllInActiveStudents();
    }

    //deleteByColumnNameStudentName :-
    public void deleteStudentByColumnNameStudentName(String name){
        Student studentToDelete = studentRepository.getStudentByStudentName(name);
        //  School schoolToDelete = schoolRepository.findById(id).get();
        studentRepository.delete(studentToDelete);
    }

    //updateCreatedDateByUserInputForStudent :-
    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        Student student = studentRepository.getStudentById(id);
        student.setCreatedDate(convertedDateFromStringToDateFormat);
        studentRepository.save(student);
    }


    public void getPutIsActiveFalseByStudentId(Integer id) {

        studentRepository.getPutIsActiveFalseByStudentId(id);
    }

    public void getPutIsActiveFalseByStudentName(String name) {

        studentRepository.getPutIsActiveFalseByStudentName(name);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllSchools
    public void getPutIsActiveFalseForAllStudents() {
        studentRepository.getPutIsActiveFalseForAllStudents();
        //    school.setActive(false);
        //  schoolRepository.saveAll(schools);
    }

    public void getUpdateStudentById(Integer id,String name) {
        studentRepository.getUpdateStudentById(id,name);
        //    school.setActive(false);
        //  schoolRepository.saveAll(schools);
    }

    public Student getLatestRowStudent() {

        return studentRepository.getLatestRowStudent();
    }

    //getLatestUpdated
    public Student getLatestUpdatedStudent() {
        Student student = studentRepository.getLatestUpdatedStudent();
        return student;
    }

    //getCreatedAfterDate
    public List<Student> getCreatedAfterDateStudent(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Student> student = studentRepository.getCreatedAfterDateStudent(convertedDateFromStringToDateFormat);
        return student;
    }

    //UpdateIsActiveTrueBySchoolId
    public void getUpdateIsActiveTrueByStudentId(Integer id) {

        studentRepository.getUpdateIsActiveTrueByStudentId(id);
    }

    //updateUpdatedDateById
    public void setUpdateUpdatedDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        Student student = studentRepository.getStudentById(id);
        student.setUpdatedDate(convertedDateFromStringToDateFormat);
        studentRepository.save(student);
    }

    //addNewStudentDependOfStudentInput
    public void addNewStudentDependOfStudentInput (@RequestParam String studentName, @RequestParam String rollNumber, @RequestParam Boolean isActive) {

        Student sObj = new Student();
        sObj.setName(studentName);
        sObj.setRollNumber(rollNumber);
        sObj.setActive(isActive);
        studentRepository.save(sObj);
    }

    //getStudentByCreatedDate
    //note: always date we will convert it to string, with parseException
    public List<Student> getStudentByCreatedDate(String createdDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(createdDate);
        List<Student> student = studentRepository.getStudentByCreatedDate(convertedDateFromStringToDateFormat);
        return student;
    }

    //deleteStudentsByCreatedDate -> put isActive false by createdDate :-
    public void getUpdateIsActiveFalseByCreatedDate(String createdDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(createdDate);
        studentRepository.getUpdateIsActiveFalseByCreatedDate(convertedDateFromStringToDateFormat);
    }







}
