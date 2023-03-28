package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    CourseController courseController;

    @Autowired
    CourseRepository courseRepository;

    @Test
    void addCourse() {
        Course course1 = new Course();
        courseRepository.save(course1);
    }

    @Test
    void getAllCourses() {
        List<Course> courses = courseRepository.getAllCourses();
    }

    @Test
    void deleteCourseById() {
        courseRepository.getPutIsActiveFalseByCourseId(6);
    }

    @Test
    void getCourseById() throws Exception {
        Course courseToTest=courseController.getCourseById(6);
        String courseName=courseToTest.getName();
        assertEquals("arabic",courseName);
    }

    @Test
    void getCourseByCourseName() {
        Course courseToTest=courseController.getCourseByCourseName("arabic");
        Integer courseId=courseToTest.getId();
        assertEquals(6,courseId);
    }

    @Test
    void getAllActiveCourses() {
        List<Course> activeCourses = courseRepository.getAllActiveCourses();
    }

    @Test
    void getAllInActiveCourses() {
        List<Course> notActiveCourse= courseRepository.getAllInActiveCourses();
    }

    @Test
    void deleteCourseByColumnNameCourseName() {
        courseRepository.getPutIsActiveFalseByCourseName("arabic");
    }

    @Test
    void setCreatedDateByUserInput() {
    }

    @Test
    void getPutIsActiveFalseByCourseId() {
        courseRepository.getPutIsActiveFalseByCourseId(6);
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