package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    CourseController courseController;



    @Test
    void addCourse() {
        courseController.addCourse();
    }

    @Test
    void getAllCourses() {
        List<Course> courses = courseController.getAllCourses();
        String courseName=courses.get(0).getName(); // it will test the courseName if exists in db depend of the index gave. exp: .get(0).
        assertEquals("arabic",courseName);
    }

    @Test
    void deleteCourseById() {
        courseController.getPutIsActiveFalseByCourseId(6);
    }

    @Test
    void getCourseById() throws Exception {
        Course courseToTest=courseController.getCourseById(11);
        String courseName=courseToTest.getName();
        assertEquals("python",courseName);
    }

    @Test
    void getCourseByCourseName() {
        Course courseToTest=courseController.getCourseByCourseName("arabic");
        Integer courseId=courseToTest.getId();
        assertEquals(6,courseId);
    }

    @Test
    void getAllActiveCourses() {
        List<Course> activeCourses = courseController.getAllActiveCourses();
        assertEquals("python", activeCourses.get(0).getName()); //.get(0) means first Course Active(in order from db)
    }

    @Test
    void getAllInActiveCourses() {
        List<Course> notActiveCourses= courseController.getAllInActiveCourses();
        assertEquals("arabic", notActiveCourses.get(0).getName());
    }

    @Test
    void deleteCourseByColumnNameCourseName() {
        courseController.getPutIsActiveFalseByCourseName("python"); //post
    }

    @Test
    void setCreatedDateByUserInput() throws ParseException {
        courseController.setCreatedDateByUserInput("2012-12-12 00:00:00.0000000",11); //post
    }

    @Test
    void getPutIsActiveFalseByCourseId() {
        courseController.getPutIsActiveFalseByCourseId(6);
    }

    @Test
    void getPutIsActiveFalseByCourseName() {
        courseController.getPutIsActiveFalseByCourseName("python");
    }

    @Test
    void getPutIsActiveFalseForAllCourses() {
        courseController.getPutIsActiveFalseForAllCourses(); //post
    }

    @Test
    void getUpdateCourseById() {
        courseController.getUpdateCourseById(31,"najateez");
    }

    @Test
    void getLatestRowCourse() {
        Course courseToTest=courseController.getLatestRowCourse();
        Date LatestRow=courseToTest.getCreatedDate();
        assertEquals("2012-12-12 00:00:00.0",LatestRow.toString());
    }

    @Test
    void getLatestUpdatedCourse() {
    }

    @Test
    void getCreatedAfterDateCourse() {
    }

    @Test
    void getUpdateIsActiveTrueByCourseId() {
        courseController.getUpdateIsActiveTrueByCourseId(11); //post
    }

    @Test
    void setUpdateUpdatedDateByUserInput() {
    }

    @Test
    void addNewCourseDependOfCourseInput() {
        courseController.addNewCourseDependOfCourseInput("java",true); //post
    }

    @Test
    void getCourseByCreatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() throws ParseException {
        courseController.getUpdateIsActiveFalseByCreatedDate("2012-12-12 00:00:00.0000000");
    }

    @Test
    void getCourseByUpdatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() throws ParseException {
        courseController.getUpdateIsActiveFalseByUpdatedDate("2023-04-03 13:49:21.8220000"); //post
    }

    @Test
    void getDeleteAllCoursesCreatedAfterDate() throws ParseException {
        courseController.getDeleteAllCoursesCreatedAfterDate("1111-04-03 00:00:00.0000000"); //post
    }
}