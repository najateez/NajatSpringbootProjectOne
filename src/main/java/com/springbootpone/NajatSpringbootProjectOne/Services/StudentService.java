package com.springbootpone.NajatSpringbootProjectOne.Services;


import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   //this will be my service
public class StudentService {


    // every function called bean
    @Autowired   // it is dependancy injection
    StudentRepository studentRepository;

    public void addStudent(){

        Student studentObj=new Student();
        studentObj.setName("Najatiix");
        studentObj.setRollNumber("77");
        studentRepository.save(studentObj);

    }


}
