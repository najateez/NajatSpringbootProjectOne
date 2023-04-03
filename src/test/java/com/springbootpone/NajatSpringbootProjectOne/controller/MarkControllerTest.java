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

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarkControllerTest {

    @Autowired
    MarkController markController;



    @Test
    void addMark() {
        markController.addMark();
    }

    @Test
    void getAllMarks() {
        List<Mark> marks = markController.getAllMarks();
        Integer obtainedMark=marks.get(2).getObtainedMarks();// it will test the obtainedMark if exists in db depend of the index gave. exp: .get(2).
        assertEquals(50,obtainedMark);
    }

    @Test
    void deleteMarkById() {
        markController.getPutIsActiveFalseByMarkId(4);
    }

    @Test
    void getMarkById() {
        Mark markToTest=markController.getMarkById(7);
        String grade=markToTest.getGrade();
        assertEquals("very good",grade);
    }

    @Test
    void getMarkByObtainedMarks() {
        Mark markToTest=markController.getMarkByObtainedMarks(50);
        Integer markId=markToTest.getId();
        assertEquals(5,markId);
    }

    @Test
    void getAllActiveMarks() {
        List<Mark> activeMarks = markController.getAllActiveMarks();
        assertEquals(96, activeMarks.get(0).getObtainedMarks()); //.get(0) means first Mark Active(in order from db)
    }

    @Test
    void getAllInActiveMarks() {
        List<Mark> notActiveMarks= markController.getAllInActiveMarks();
        assertEquals(30, notActiveMarks.get(0).getObtainedMarks());
    }

    @Test
    void deleteMarkByColumnNameObtainedMark() {
        markController.getPutIsActiveFalseByColumnNameObtainedMarks(94);  //post
    }

    @Test
    void setCreatedDateByUserInput() throws ParseException {
        markController.setCreatedDateByUserInput("2005-5-22 22:00:00.0000000",7); //post
    }

    @Test
    void getPutIsActiveFalseByMarkId() {
        markController.getPutIsActiveFalseByMarkId(6);
    }

    @Test
    void getPutIsActiveFalseByColumnNameObtainedMarks() {
        markController.getPutIsActiveFalseByColumnNameObtainedMarks(30);
    }

    @Test
    void getPutIsActiveFalseForAllMarks() {
        markController.getPutIsActiveFalseForAllMarks(); //post
    }

    @Test
    void getUpdateMarkById() {
        markController.getUpdateMarkById(6,20);
    }

    @Test
    void getLatestRowMark() {
        Mark markToTest=markController.getLatestRowMark();
        Date LatestRow=markToTest.getCreatedDate();
        assertEquals("2005-04-03 00:00:00.0",LatestRow.toString());
    }

    @Test
    void getLatestUpdatedMark() {
    }

    @Test
    void getCreatedAfterDateMark() {
    }

    @Test
    void getUpdateIsActiveTrueByMarkId() {
        markController.getUpdateIsActiveTrueByMarkId(4); //post
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
        markController.addNewMarkDependOfMarkInput("good",79,true); //post
    }

    @Test
    void getMarkByCreatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() throws ParseException {
        markController.getUpdateIsActiveFalseByCreatedDate("2000-09-08 00:00:00.0000000");
    }

    @Test
    void getMarkByUpdatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() throws ParseException {
        markController.getUpdateIsActiveFalseByUpdatedDate("2023-04-03 00:00:00.0000000"); //post
    }

    @Test
    void getDeleteAllMarksCreatedAfterDate() throws ParseException {
        markController.getDeleteAllMarksCreatedAfterDate("2000-09-08 00:00:00.0000000"); //post
    }
}