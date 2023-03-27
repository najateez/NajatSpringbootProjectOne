package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarkControllerTest {

    @Autowired
    MarkController markController;

    @Test
    void addMark() {
    }

    @Test
    void getAllMarks() {
    }

    @Test
    void deleteMarkById() {
    }

    @Test
    void getMarkById() {
        Mark markToTest=markController.getMarkById(6);
        String grade=markToTest.getGrade();
        assertEquals("fail",grade);
    }

    @Test
    void getCourseByCourseName() {
    }

    @Test
    void getAllActiveMarks() {
    }

    @Test
    void getAllInActiveMarks() {
    }

    @Test
    void deleteMarkByColumnNameGrade() {
    }

    @Test
    void setCreatedDateByUserInput() {
    }

    @Test
    void getPutIsActiveFalseByMarkId() {
    }

    @Test
    void getPutIsActiveFalseByColumnNameObtainedMarks() {
    }

    @Test
    void getPutIsActiveFalseForAllMarks() {
    }

    @Test
    void getUpdateMarkById() {
    }

    @Test
    void getLatestRowMark() {
    }

    @Test
    void getLatestUpdatedMark() {
    }

    @Test
    void getCreatedAfterDateMark() {
    }

    @Test
    void getUpdateIsActiveTrueByMarkId() {
    }

    @Test
    void setUpdateUpdatedDateByUserInput() {
    }

    @Test
    void getByObtainedMarksMoreThan() {
    }

    @Test
    void getByObtainedMarksLessThan() {
    }

    @Test
    void addNewMarkDependOfMarkInput() {
    }

    @Test
    void getMarkByCreatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() {
    }

    @Test
    void getMarkByUpdatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() {
    }

    @Test
    void getDeleteAllMarksCreatedAfterDate() {
    }
}