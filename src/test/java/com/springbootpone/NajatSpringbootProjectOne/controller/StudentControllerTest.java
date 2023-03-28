package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentController studentController;

    @Autowired
    StudentRepository studentRepository;

    @Test
    void addStudent() {
        Student student1 = new Student();
        studentRepository.save(student1);
    }

    @Test
    void getAllStudents() {
        List<Student> students = studentRepository.getAllStudents();
    }

    @Test
    void deleteStudentById() {
        studentRepository.getPutIsActiveFalseByStudentId(4);
    }

    @Test
    void getStudentById() {
        Student studentToTest=studentController.getStudentById(44);
        String studentName=studentToTest.getName();
        assertEquals("jannat",studentName);
    }

    @Test
    void getStudentByStudentName() {
        Student studentToTest=studentController.getStudentByStudentName("alkhatria");
        Integer studentId=studentToTest.getId();
        assertEquals(17,studentId);
    }

    @Test
    void getAllActiveStudents() {
        List<Student> activeStudents = studentRepository.getAllActiveStudents();
    }

    @Test
    void getAllInActiveStudents() {
        List<Student> notActiveStudents= studentRepository.getAllInActiveStudents();
    }

    @Test
    void deleteStudentByColumnNameStudentName() {
        studentRepository.getPutIsActiveFalseByStudentName("disney");
    }

    @Test
    void setCreatedDateByUserInput() {
    }

    @Test
    void getPutIsActiveFalseByStudentId() {
        studentRepository.getPutIsActiveFalseByStudentId(6);
    }

    @Test
    void getPutIsActiveFalseByStudentName() {
    }

    @Test
    void getPutIsActiveFalseForAllStudents() {
    }

    @Test
    void getUpdateStudentById() {
    }

    @Test
    void getLatestRowStudent() {
    }

    @Test
    void getLatestUpdatedStudent() {
    }

    @Test
    void getCreatedAfterDateStudent() {
    }

    @Test
    void getUpdateIsActiveTrueByStudentId() {
    }

    @Test
    void setUpdateUpdatedDateByUserInput() {
    }

    @Test
    void addNewStudentDependOfStudentInput() {
    }

    @Test
    void getStudentByCreatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() {
    }

    @Test
    void getStudentByUpdatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() {
    }

    @Test
    void getDeleteAllStudentsCreatedAfterDate() {
    }
}