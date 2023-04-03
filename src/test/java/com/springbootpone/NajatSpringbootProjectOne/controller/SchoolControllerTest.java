package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import com.springbootpone.NajatSpringbootProjectOne.Services.SchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
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
    SchoolService schoolService;

    @Test
    void addSchool() {
        schoolController.addSchool();
    }

    @Test
    void getAllSchools() {
        List<School> schools = schoolController.getAllSchools();
        String schoolName=schools.get(7).getName(); // it will test the schoolName if exists in db depend of the index gave. exp: .get(7).
        assertEquals("najateezSchool",schoolName);
    }

    @Test
    void deleteSchoolById() {
       schoolController.getPutIsActiveFalseBySchoolId(75); //post
    }

    @Test
    void getSchoolById() {
        School schoolToTest=schoolController.getSchoolById(9);
        String schoolName=schoolToTest.getName();
        assertEquals("xyz",schoolName);
    }

    @Test
    void getSchoolBySchoolName() {
        School schoolToTest=schoolController.getSchoolBySchoolName("biryani");
        Integer schoolId=schoolToTest.getId();
        assertEquals(59,schoolId);
    }

    @Test
    void getAllActiveSchools() {
        List<School> activeSchools = schoolController.getAllActiveSchools();
  //      assertEquals(7, activeSchools.size()); // Assuming there are maximum two active schools
        assertEquals("xyz", activeSchools.get(0).getName()); //.get(0) means first school Active(in order from db)
   //    assertEquals("xyz", activeSchools.get(1).getName());
    }

    @Test
    void getAllInActiveSchools() {
        List<School> notActiveSchools= schoolController.getAllInActiveSchools();
        assertEquals("ajghjgjhg", notActiveSchools.get(0).getName());
    }

    @Test
    void deleteSchoolByColumnNameSchoolName() {
      schoolController.getPutIsActiveFalseBySchoolColumnName("mimi"); //post
    }

    @Test
    void setCreatedDateByUserInput() throws ParseException {
        schoolController.setCreatedDateByUserInput("1312-11-10 00:00:00.0000000",59); //post
    }
//-------------------------------------------------------
    @Test
    void getPutIsActiveFalseBySchoolId() {
   //     schoolController.getPutIsActiveFalseBySchoolId(60); //post
    }

    @Test
    void getPutIsActiveFalseBySchoolColumnName() {
     //   schoolController.getPutIsActiveFalseBySchoolColumnName("xyz"); //post
    }

    @Test
    void getPutIsActiveFalseForAllSchools() {
        schoolController.getPutIsActiveFalseForAllSchools(); //post
    }

    @Test
    void getUpdateSchoolById() {
        schoolController.getUpdateSchoolById(2,"abc"); //post
    }

    @Test
    void getLatestRowSchool() {
       School schoolToTest=schoolController.getLatestRowSchool();
        Date LatestRow=schoolToTest.getCreatedDate();
        assertEquals("2222-08-07 00:00:00.0",LatestRow.toString());  //last record in table will check createdDate. we use .toString for compare
    }

    @Test
    void getLatestUpdatedSchool() {
   /*    School schoolToTest=schoolController.getLatestUpdatedSchool();
        Date LatestUpdated=schoolToTest.getUpdatedDate();
        assertEquals("2023-04-02 21:13:49.3530000",LatestUpdated.toString());  //last record in table will check updatedDate
*/
    }

    @Test
    void getCreatedAfterDateSchool() throws ParseException {
/*        School schoolToTest=schoolController.getCreatedAfterDateSchool("4444-09-08 00:00:00.0");
      //  assertEquals(3, schoolToTest.size());
        Date createdAfterDate=schoolToTest.getCreatedDate();
        assertEquals("8080-08-09 00:00:00.0",createdAfterDate.toString()); */
    }

    @Test
    void getSchoolByNumberOfStudent() {
    //    schoolController.getSchoolByNumberOfStudent(411);
    }

    @Test
    void getUpdateIsActiveTrueBySchoolId() {
        schoolController.getUpdateIsActiveTrueBySchoolId(59); //post
    }

    @Test
    void setUpdateUpdatedDateByUserInput() throws ParseException {
     //   schoolController.setUpdateUpdatedDateByUserInput("1997-11-12 00:00:00.0000000",59);
    }

    @Test
    void addNewSchoolDependOfSchoolInput() {
        schoolController.addNewSchoolDependOfSchoolInput("disney",false); //post
    }

    @Test
    void getSchoolByCreatedDate() throws ParseException {
      //  schoolController.getSchoolByCreatedDate("9182-08-08 00:00:00.0000000");
    }

    @Test
    void getUpdateIsActiveFalseByCreatedDate() throws ParseException {
        schoolController.getUpdateIsActiveFalseByCreatedDate("1312-11-10 00:00:00.0000000"); //post
    }

    //----------------------

    @Test
    void getSchoolByUpdatedDate() throws ParseException {
    //    schoolController.getSchoolByUpdatedDate("4353-10-8 00:00:00.0000000");
    }

    @Test
    void getUpdateIsActiveFalseByUpdatedDate() throws ParseException {
        schoolController.getUpdateIsActiveFalseByUpdatedDate("2023-04-02 00:00:00.0000000"); //post
    }

    @Test
    void getDeleteAllSchoolsCreatedAfterDate() throws ParseException {
        schoolController.getDeleteAllSchoolsCreatedAfterDate("7575-12-11 00:00:00.0000000"); //post

    }
}