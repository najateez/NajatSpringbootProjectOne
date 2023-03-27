package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    CourseController courseController;

    @Test
    void addCourse() {
    }

    @Test
    void getAllCourses() {
    }

    @Test
    void deleteCourseById() {
    }

    @Test
    void getCourseById() throws Exception {
        Course courseToTest=courseController.getCourseById(6);
        String courseName=courseToTest.getName();
        assertEquals("arabic",courseName);
    }

    @Test
    void getCourseByCourseName() {
    }

    @Test
    void getAllActiveCourses() {
    }

    @Test
    void getAllInActiveCourses() {
    }

    @Test
    void deleteCourseByColumnNameCourseName() {
    }

    @Test
    void setCreatedDateByUserInput() {
    }

    @Test
    void getPutIsActiveFalseByCourseId() {
    }

    @Test
    void getPutIsActiveFalseByCourseName() {
    }

    @Test
    void getPutIsActiveFalseForAllCourses() {
    }

    @Test
    void getUpdateCourseById() {
    }

    @Test
    void getLatestRowCourse() {
    }

    @Test
    void getLatestUpdatedCourse() {
    }

    @Test
    void getCreatedAfterDateCourse() {
    }

    @Test
    void getUpdateIsActiveTrueByCourseId() {
    }

    @Test
    void setUpdateUpdatedDateByUserInput() {
    }

    @Test
    void addNewCourseDependOfCourseInput() {
    }

    @Test
    void getCourseByCreatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() {
    }

    @Test
    void getCourseByUpdatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() {
    }

    @Test
    void getDeleteAllCoursesCreatedAfterDate() {
    }
}