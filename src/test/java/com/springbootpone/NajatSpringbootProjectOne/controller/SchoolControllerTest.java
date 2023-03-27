package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchoolControllerTest {

    /* To do Testing(Unit testing)-> choose any controller code. exp: SchoolController -> right click generate->
       Test-> put tik to all function then click ok, this page will appear.
     - Add dependancy in pom.xml. (junit-jupiter).
     - Above each Test class write: @SpringBootTest.
     - Make sure SchoolController there is @RestController works or @Component.
     */

    @Autowired
    SchoolController schoolController;

    @Test
    void addSchool() {
    }

    @Test
    void getAllSchools() {
    }

    @Test
    void deleteSchoolById() {
    }

    @Test
    void getSchoolById() {
        School schoolToTest=schoolController.getSchoolById(2);
        String schoolName=schoolToTest.getName();
        assertEquals("abc",schoolName);
    }

    @Test
    void getSchoolBySchoolName() {
    }

    @Test
    void getAllActiveSchools() {
    }

    @Test
    void getAllInActiveSchools() {
    }

    @Test
    void deleteSchoolByColumnNameSchoolName() {
    }

    @Test
    void setCreatedDateByUserInput() {
    }

    @Test
    void getPutIsActiveFalseBySchoolId() {
    }

    @Test
    void getPutIsActiveFalseBySchoolColumnName() {
    }

    @Test
    void getPutIsActiveFalseForAllSchools() {
    }

    @Test
    void getUpdateSchoolById() {
    }

    @Test
    void getLatestRowSchool() {
    }

    @Test
    void getLatestUpdatedSchool() {
    }

    @Test
    void getCreatedAfterDateSchool() {
    }

    @Test
    void getSchoolByNumberOfStudent() {
    }

    @Test
    void getUpdateIsActiveTrueBySchoolId() {
    }

    @Test
    void setUpdateUpdatedDateByUserInput() {
    }

    @Test
    void addNewSchoolDependOfSchoolInput() {
    }

    @Test
    void getSchoolByCreatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() {
    }

    @Test
    void getSchoolByUpdatedDate() {
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() {
    }

    @Test
    void getDeleteAllSchoolsCreatedAfterDate() {
    }
}