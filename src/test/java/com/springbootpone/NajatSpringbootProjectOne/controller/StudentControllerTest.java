package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentController studentController;

    @Test
    void addStudent() {
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void deleteStudentById() {
    }

    @Test
    void getStudentById() {
        Student studentToTest=studentController.getStudentById(44);
        String studentName=studentToTest.getName();
        assertEquals("jannat",studentName);
    }

    @Test
    void getStudentByStudentName() {
    }

    @Test
    void getAllActiveStudents() {
    }

    @Test
    void getAllInActiveStudents() {
    }

    @Test
    void deleteStudentByColumnNameStudentName() {
    }

    @Test
    void setCreatedDateByUserInput() {
    }

    @Test
    void getPutIsActiveFalseByStudentId() {
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