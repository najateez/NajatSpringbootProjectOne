package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    SchoolRepository schoolRepository;

    @Test
    void addSchool() {
        School school1 = new School();
        schoolRepository.save(school1);
   //     List<School> schools = schoolRepository.findAll();
    }

    @Test
    void getAllSchools() {
        List<School> schools = schoolRepository.getAllSchools();
    }

    @Test
    void deleteSchoolById() {
        schoolRepository.getPutIsActiveFalseBySchoolId(60);


/*        String schoolName="xyz";
        schoolRepository.getPutIsActiveFalseBySchoolId(9); */

 /*     School schoolObj = new School();
       schoolObj.setName("najateezSchool");
        schoolRepository.save(schoolObj);

         schoolRepository.getPutIsActiveFalseBySchoolId(schoolObj.getId()); */
    }

    @Test
    void getSchoolById() {
        School schoolToTest=schoolController.getSchoolById(2);
        String schoolName=schoolToTest.getName();
        assertEquals("abc",schoolName);
    }

    @Test
    void getSchoolBySchoolName() {
        School schoolToTest=schoolController.getSchoolBySchoolName("xyz");
        Integer schoolId=schoolToTest.getId();
        assertEquals(9,schoolId);
    }

    @Test
    void getAllActiveSchools() {
        List<School> activeSchools = schoolRepository.getAllActiveSchools();
    }

    @Test
    void getAllInActiveSchools() {
        List<School> notActiveSchools= schoolRepository.getAllInActiveSchools();
    }

    @Test
    void deleteSchoolByColumnNameSchoolName() {
        schoolRepository.getPutIsActiveFalseBySchoolColumnName("twixxxia");
    }

    @Test
    void setCreatedDateByUserInput() {

    }

    @Test
    void getPutIsActiveFalseBySchoolId() {
        schoolRepository.getPutIsActiveFalseBySchoolId(59);
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