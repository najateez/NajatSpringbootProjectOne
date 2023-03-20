package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.springbootpone.NajatSpringbootProjectOne.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

//@RestController
public class SchoolController {

    /* After using extends of (BaseEntity class), we create for each class seperate controller. and all codes
      which is related to school will be here. student to student. course to course. mark to mark. but combination
      between 2 classes as fk , should be in FirstController.
     */

    /* For now because we have more than one cotroller for each class its own controller, so will not work
    all of them at the same time if we put @RestController for each class, will show errors during run time.
     thats why i commented remaining @RestController ,just in this class there is.
     - We should add one notation @RestController for one controller only to see if it is working.
     */

    @Autowired
    SchoolService schoolService;  //bean

    // for inserting : exp : localhost:8080
    @GetMapping
    public void addSchool() {

        schoolService.addSchool();
    }

    /* must be one @GetMapping to put , just for table that you want to insert values. can not write above
     all functions, it will show errors during run time.
     */

    /* - when you want to insert any value in any table just put notation @GetMapping above that add function
    and it will insert values of that table.  ONLY one table can insert value at a time.  (for ONE TABLE).
     */

    //to show data which is added in table into screen in localhost and postman
    //exp: localhost:8080/school/getAll
    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return schools;
    }

    //exp: localhost:8080/school/deleteById?id=7
    @GetMapping(value = "school/deleteById")
    public String deleteSchoolById(@RequestParam Integer id) {

        schoolService.deleteSchoolById(id);
        return "Record of school table deleted successfully";
    }

    //getById :-
    //exp: localhost:8080/school/getById?schoolId=2  . coulmnName = depend on what you write in sqlQuery , user input.
    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    //getByColumnName:-
    // exp : localhost:8080/school/getByColumnSchoolName?schoolName=abc .   SchoolName ->that user input
    @RequestMapping(value = "school/getByColumnSchoolName", method = RequestMethod.GET)
    public School getSchoolBySchoolName(@RequestParam String schoolName) {
        School school = schoolService.getSchoolBySchoolName(schoolName);
        return school;
    }

    // getAllActiveSchools :-
    @RequestMapping(value = "getAllSchoolsByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

    // getAllNotActiveSchools :-
    @RequestMapping(value = "getAllSchoolsByIsActiveFalse")
    public List<School> getAllInActiveSchools() {
        List<School> notActiveSchoolsList = schoolService.getAllInActiveSchools();
        return notActiveSchoolsList;
    }

    //deleteSchoolByColumnNameSchoolName :-
    @GetMapping(value = "school/deleteByColumnNameSchoolName")
    public String deleteSchoolByColumnNameSchoolName(@RequestParam String name) {

        schoolService.deleteSchoolByColumnNameSchoolName(name);
        return "Record of school table deleted successfully";
    }

    //updateCreatedDateByUserInputForSchool :-
    // for GET use @RequestParam. but for POST use @RequestBody .
    //exp: localhost:8080/updateCreatedDateByUserInput?date=2222-10-11&id=2
    //POST
    @RequestMapping(value = "updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        schoolService.setCreatedDateByUserInput(date, id);
    }

    //deleteById--> they mean  MakeIsActiveFalseBySchoolId
    //exp: localhost:8080/deleteSchoolByIdIsActiveFalse?schoolId=2
    //POST
    @RequestMapping(value = "deleteSchoolByIdIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseBySchoolId(@RequestParam Integer schoolId) {
        schoolService.getPutIsActiveFalseBySchoolId(schoolId);
    }

    //deleteByColumnName--> they mean  MakeIsActiveFalseBySchoolName
    //exp: localhost:8080/school/deleteBySchoolNameIsActiveFalse?schoolName=abc
    //POST
    @RequestMapping(value = "school/deleteBySchoolNameIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseBySchoolColumnName(@RequestParam String schoolName) {
        schoolService.getPutIsActiveFalseBySchoolColumnName(schoolName);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllSchools
    //exp: localhost:8080/school/deleteByAllPutIsActiveFalseBySchoolForAll
    @RequestMapping(value = "school/deleteByAllPutIsActiveFalseBySchoolForAll", method = RequestMethod.POST)
    public void getPutIsActiveFalseForAllSchools() {
        schoolService.getPutIsActiveFalseForAllSchools();
    }

    //updateSchool :-
    //exp: localhost:8080/school/updateSchool?schoolName=shambaqbaq&schoolId=59
    @RequestMapping(value = "school/updateSchool", method = RequestMethod.POST)
    public void getUpdateSchoolById(@RequestParam Integer schoolId, @RequestParam String schoolName) {
        schoolService.getUpdateSchoolById(schoolId,schoolName);
    }

    //getLatestRow :-
    // exp: localhost:8080/school/getLatestRowSchool
    //POST
    @RequestMapping(value = "school/getLatestRowSchool")
    public School getLatestRowSchool() {
        School school = schoolService.getLatestRowSchool();
        return school;
    }

    //getLatestUpdated
    //exp: localhost:8080/school/getLatestUpdatedSchool
  @RequestMapping(value = "school/getLatestUpdatedSchool", method = RequestMethod.GET)
    public School getLatestUpdatedSchool() {
        School school = schoolService.getLatestUpdatedSchool();
        return school;

    }

    //getCreatedAfterDate
    @RequestMapping(value = "school/getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getCreatedAfterDateSchool(@RequestParam String createdDate) throws ParseException {
        List<School> createdAfterDate = schoolService.getCreatedAfterDateSchool(createdDate);
        return createdAfterDate;
    }

    //getSchoolByNumberOfStudents -> means how many students in one school
    /* for this situation we will use StudentRepository,SchoolService,SchoolController.

            //exp: count similar school_id in student table and write it in postman.
          exp: localhost:8080/school/getSchoolByNumberOfStudent?numberOfStudent=4            //for school_id=59

    check from student table school id, count similar number and write in link numberOfStudent=4. the original school_id=59
     */

    //getSchoolByNumberOfStudents
    @RequestMapping(value = "school/getSchoolByNumberOfStudent", method = RequestMethod.POST)
    public List<School> getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {

        List<School> schoolList=schoolService.getSchoolByNumberOfStudent(numberOfStudent);
        return schoolList;
    }

    //UpdateIsActiveTrueBySchoolId
    @RequestMapping(value = "school/updateIsActiveToTrueBySchoolId", method = RequestMethod.POST)
    public void getUpdateIsActiveTrueBySchoolId(@RequestParam Integer schoolId) {
        schoolService.getUpdateIsActiveTrueBySchoolId(schoolId);
    }

    //updateUpdatedDateByUserInputForSchool :-
    // for GET use @RequestParam. but for POST use @RequestBody .
    //exp: localhost:8080/updateUpdatedDateByUserInput?date=2222-10-11&id=2
    //POST
        @RequestMapping(value = "school/updateUpdatedDateByUserInput")
    public void setUpdateUpdatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        schoolService.setUpdateUpdatedDateByUserInput(date, id);
    }

    //addNewSchoolDependOfSchoolInput
    //exp: localhost:8080/school/addNewSchoolDependOfSchoolInput?schoolName=twixxxia&isActive=true
    //used SchoolService, schoolController.
    //same as previous code of addSchool() but with parameter.
    @RequestMapping(value = "school/addNewSchoolDependOfSchoolInput", method = RequestMethod.POST)
    public void addNewSchoolDependOfSchoolInput(@RequestParam String schoolName, @RequestParam Boolean isActive) {

        schoolService.addNewSchoolDependOfSchoolInput(schoolName,isActive);
    }

    //getSchoolByCreatedDate :-
    //exp: localhost:8080/school/getSchoolByCreatedDate?createdDate=7575-12-11 00:00:00.0000000
    //note: always date we will convert it to string, with parseException
   @RequestMapping(value = "school/getSchoolByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByCreatedDate(@RequestParam String createdDate) throws ParseException {
       List<School> school = schoolService.getSchoolByCreatedDate(createdDate);
        return school;
    }


    //getSchoolByUpdatedDate
 /*   @RequestMapping(value = "school/getSchoolByUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        List<School> school = schoolService.getSchoolByUpdatedDate(updatedDate);
        return school;
    } */


    //deleteSchoolsByCreatedDate -> put isActive false by createdDate :-
    //exp: localhost:8080/school/UpdateIsActiveFalseByCreatedDate?createdDate=7575-12-11 00:00:00.0000000
    @RequestMapping(value = "school/UpdateIsActiveFalseByCreatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByCreatedDate(@RequestParam String createdDate) throws ParseException{
         schoolService.getUpdateIsActiveFalseByCreatedDate(createdDate);
    }

    //deleteSchoolsByCreatedDate -> put isActive false by createdDate :-
 /*   @RequestMapping(value = "school/UpdateIsActiveFalseByUpdatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByUpdatedDate(@RequestParam String updatedDate) throws ParseException{
        schoolService.getUpdateIsActiveFalseByUpdatedDate(updatedDate);
    } */







}
