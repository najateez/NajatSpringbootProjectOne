package com.springbootpone.NajatSpringbootProjectOne.Services;


import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        studentObj.setName("pppp");
        studentObj.setRollNumber("982");
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







}
