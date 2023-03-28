package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.CourseRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.MarkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarkControllerTest {

    @Autowired
    MarkController markController;

    @Autowired
    MarkRepository markRepository;

    @Test
    void addMark() {
        Mark mark1 = new Mark();
        markRepository.save(mark1);
    }

    @Test
    void getAllMarks() {
        List<Mark> marks = markRepository.getAllMarks();
    }

    @Test
    void deleteMarkById() {
        markRepository.getPutIsActiveFalseByMarkId(5);
    }

    @Test
    void getMarkById() {
        Mark markToTest=markController.getMarkById(6);
        String grade=markToTest.getGrade();
        assertEquals("fail",grade);
    }

 /*   @Test
    void getMarkByGrade() {
        Mark markToTest=markController.getMarkByGrade("good");
        Integer markId=markToTest.getId();
        assertEquals(6,markId);
    } */

    @Test
    void getAllActiveMarks() {
        List<Mark> activeMarks = markRepository.getAllActiveMarks();
    }

    @Test
    void getAllInActiveMarks() {
        List<Mark> notActiveMark= markRepository.getAllInActiveMarks();
    }

    @Test
    void deleteMarkByColumnNameObtainedMark() {
        markRepository.getPutIsActiveFalseByColumnNameObtainedMarks(96);
    }

    @Test
    void setCreatedDateByUserInput() {
    }

    @Test
    void getPutIsActiveFalseByMarkId() {
        markRepository.getPutIsActiveFalseByMarkId(5);
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