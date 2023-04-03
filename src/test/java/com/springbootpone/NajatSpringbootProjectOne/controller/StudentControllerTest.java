package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentController studentController;



    @Test
    void addStudent() {
        studentController.addStudent();
    }

    @Test
    void getAllStudents() {
        List<Student> students = studentController.getAllStudents();
        String studentName=students.get(2).getName(); // it will test the studentName if exists in db depend of the index gave. exp: .get(2).
        assertEquals("aweeehah",studentName);
    }

    @Test
    void deleteStudentById() {
        studentController.getPutIsActiveFalseByStudentId(31); //post
    }

    @Test
    void getStudentById() {
        Student studentToTest=studentController.getStudentById(49);
        String studentName=studentToTest.getName();
        assertEquals("shambeeeh",studentName);
    }

    @Test
    void getStudentByStudentName() {
        Student studentToTest=studentController.getStudentByStudentName("alkhatria");
        Integer studentId=studentToTest.getId();
        assertEquals(17,studentId);
    }

    @Test
    void getAllActiveStudents() {
        List<Student> activeStudents = studentController.getAllActiveStudents();
        assertEquals("aweeehah", activeStudents.get(0).getName()); //.get(0) means first student Active(in order from db)
    }

    @Test
    void getAllInActiveStudents() {
        List<Student> notActiveStudents= studentController.getAllInActiveStudents();
        assertEquals("Najatiix", notActiveStudents.get(0).getName());
    }

    @Test
    void deleteStudentByColumnNameStudentName() {
        studentController.getPutIsActiveFalseByStudentName("pppp"); //post
    }

    @Test
    void setCreatedDateByUserInput() throws ParseException {
        studentController.setCreatedDateByUserInput("1996-9-6 00:00:00.0000000",17); //post
    }

    @Test
    void getPutIsActiveFalseByStudentId() {
        studentController.getPutIsActiveFalseByStudentId(18);
    }

    @Test
    void getPutIsActiveFalseByStudentName() {
        studentController.getPutIsActiveFalseByStudentName("jannat");
    }

    @Test
    void getPutIsActiveFalseForAllStudents() {
        studentController.getPutIsActiveFalseForAllStudents(); //post
    }

    @Test
    void getUpdateStudentById() {
        studentController.getUpdateStudentById(31,"najateez");
    }

    @Test
    void getLatestRowStudent() {
        Student studentToTest=studentController.getLatestRowStudent();
        Date LatestRow=studentToTest.getCreatedDate();
        assertEquals("1996-06-08 00:00:00.0",LatestRow.toString());
    }

    @Test
    void getLatestUpdatedStudent() {
    }

    @Test
    void getCreatedAfterDateStudent() {
    }

    @Test
    void getUpdateIsActiveTrueByStudentId() {
        studentController.getUpdateIsActiveTrueByStudentId(17); //post
    }

    @Test
    void setUpdateUpdatedDateByUserInput() {
    }

    @Test
    void addNewStudentDependOfStudentInput() {
        studentController.addNewStudentDependOfStudentInput("shambalala","7407",true); //post
    }

    @Test
    void getStudentByCreatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() throws ParseException {
        studentController.getUpdateIsActiveFalseByCreatedDate("1996-09-06 00:00:00.0000000");
    }

    @Test
    void getStudentByUpdatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() throws ParseException {
        studentController.getUpdateIsActiveFalseByUpdatedDate("2023-03-13 00:00:00.0000000"); //post
    }

    @Test
    void getDeleteAllStudentsCreatedAfterDate() throws ParseException {
        studentController.getDeleteAllStudentsCreatedAfterDate("2002-07-06 00:00:00.0000000"); //post
    }
}