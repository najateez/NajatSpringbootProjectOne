package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


//@Component
//@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public void addCourse(){

        courseService.addCourse();
    }

    @RequestMapping(value="course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses(){
        List<Course> theCourse = courseService.getAllCourses();
        return theCourse;
    }

    @GetMapping(value = "course/deleteById")
    public String deleteCourseById(@RequestParam Integer id){

        courseService.deleteCourseById(id);
        return "Record of course table deleted successfully";
    }

    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId){
        Course course = courseService.getCourseById(courseId);
        return course;
    }

    @RequestMapping(value = "course/getByColumnCourseName", method = RequestMethod.GET)
    public Course getCourseByCourseName(@RequestParam String courseName){
        Course course = courseService.getCourseByCourseName(courseName);
        return course;
    }

    // getAllActiveCourses :-
    @RequestMapping(value = "getAllCoursesByIsActive")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCoursesList = courseService.getAllActiveCourses();
        return activeCoursesList;
    }

    // getAllNotActiveCourses :-
    @RequestMapping(value = "getAllCoursesByIsActiveFalse")
    public List<Course> getAllInActiveCourses() {
        List<Course> notActiveCoursesList = courseService.getAllInActiveCourses();
        return notActiveCoursesList;
    }

    //deleteCourseByColumnNameCourseName :-
    @GetMapping(value = "course/deleteByColumnNameCourseName")
    public String deleteCourseByColumnNameCourseName(@RequestParam String name) {

        courseService.deleteCourseByColumnNameCourseName(name);
        return "Record of course table deleted successfully";
    }

    //updateCreatedDateByUserInputForCourse :-
    @RequestMapping(value = "course/updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        courseService.setCreatedDateByUserInput(date, id);
    }

    //deleteById--> they mean  MakeIsActiveFalseByCourseId
    @RequestMapping(value = "deleteCourseByIdIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseByCourseId(@RequestParam Integer courseId) {
        courseService.getPutIsActiveFalseByCourseId(courseId);
    }

    //deleteByColumnName--> they mean  MakeIsActiveFalseBySchoolName
    @RequestMapping(value = "course/deleteByCourseNameIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseByCourseName(@RequestParam String courseName) {
        courseService.getPutIsActiveFalseByCourseName(courseName);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllSchools
    //exp: localhost:8080/school/deleteByAllPutIsActiveFalseBySchoolForAll
    @RequestMapping(value = "course/deleteByAllPutIsActiveFalseByCourseForAll", method = RequestMethod.POST)
    public void getPutIsActiveFalseForAllCourses() {
        courseService.getPutIsActiveFalseForAllCourses();
    }

    //updateCourse :-
    //exp: localhost:8080/course/updateCourse?courseName=math&courseId=6
    @RequestMapping(value = "course/updateCourse", method = RequestMethod.POST)
    public void getUpdateCourseById(@RequestParam Integer courseId, @RequestParam String courseName) {
        courseService.getUpdateCourseById(courseId,courseName);
    }

    //getLatestRow
    // exp: localhost:8080/course/getLatestRowCourse
    @RequestMapping(value = "course/getLatestRowCourse")
    public Course getLatestRowCourse() {
        Course course = courseService.getLatestRowCourse();
        return course;
    }

    //getLatestUpdated
    @RequestMapping(value = "course/getLatestUpdatedCourse", method = RequestMethod.GET)
    public Course getLatestUpdatedCourse() {
        Course course = courseService.getLatestUpdatedCourse();
        return course;
    }

    //getCreatedAfterDate
    @RequestMapping(value = "course/getCourseCreatedAfterDate", method = RequestMethod.GET)
    public List<Course> getCreatedAfterDateCourse(@RequestParam String createdDate) throws ParseException {
        List<Course> createdAfterDate = courseService.getCreatedAfterDateCourse(createdDate);
        return createdAfterDate;
    }

    //UpdateIsActiveTrueByCourseId
    @RequestMapping(value = "course/updateIsActiveToTrueByCourseId", method = RequestMethod.POST)
    public void getUpdateIsActiveTrueByCourseId(@RequestParam Integer courseId) {
        courseService.getUpdateIsActiveTrueByCourseId(courseId);
    }

    //updateUpdatedDateByUserInputForCourse :-
    //exp: localhost:8080/course/updateUpdatedDateByUserInput?date=1234-12-11&id=6
    @RequestMapping(value = "course/updateUpdatedDateByUserInput")
    public void setUpdateUpdatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        courseService.setUpdateUpdatedDateByUserInput(date, id);
    }

    //addNewCourseDependOfCourseInput
    //exp: localhost:8080/course/addNewCourseDependOfCourseInput?courseName=php&isActive=true
    //used SchoolService, schoolController.
    //same as previous code of addSchool() but with parameter.
    @RequestMapping(value = "course/addNewCourseDependOfCourseInput", method = RequestMethod.POST)
    public void addNewCourseDependOfCourseInput(@RequestParam String courseName, @RequestParam Boolean isActive) {

        courseService.addNewCourseDependOfCourseInput(courseName,isActive);
    }

    //getCourseByCreatedDate :-
    //exp: localhost:8080/course/getCourseByCreatedDate?createdDate=1111-04-03 00:00:00.0000000
    //note: always date we will convert it to string, with parseException
    @RequestMapping(value = "course/getCourseByCreatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByCreatedDate(@RequestParam String createdDate) throws ParseException {
        List<Course> course = courseService.getCourseByCreatedDate(createdDate);
        return course;
    }

    //deleteCoursesByCreatedDate -> put isActive false by createdDate :-
    @RequestMapping(value = "course/UpdateIsActiveFalseByCreatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByCreatedDate(@RequestParam String createdDate) throws ParseException{
        courseService.getUpdateIsActiveFalseByCreatedDate(createdDate);
    }

    //getCourseByUpdatedDate
    //exp: localhost:8080/course/getCourseByUpdatedDate?updatedDate=2023-03-13 00:00:00.0000000
    //to work this code should time be in db all zero's.
    @RequestMapping(value = "course/getCourseByUpdatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        List<Course> course = courseService.getCourseByUpdatedDate(updatedDate);
        return course;
    }

    //deleteCoursesByUpdatedDate -> put isActive false by UpdatedDate :-
    //exp: localhost:8080/course/UpdateIsActiveFalseByUpdatedDate?updatedDate=2023-03-19 00:00:00.0000000
    // to work this one should time be in db all zero's.
    @RequestMapping(value = "course/UpdateIsActiveFalseByUpdatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        courseService.getUpdateIsActiveFalseByUpdatedDate(updatedDate);
    }

    //deleteAllCoursesCreatedAfterDate -> put isActive false for AllSchoolsCreatedAfterDate
    //exp: localhost:8080/course/deleteAllCoursesCreatedAfterDate?createdDate=1111-04-03 00:00:00.0000000
    // to work this one should time be in db all zero's.
    @RequestMapping(value = "course/deleteAllCoursesCreatedAfterDate", method = RequestMethod.POST)
    public void getDeleteAllCoursesCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        courseService.getDeleteAllCoursesCreatedAfterDate(createdDate);

    }


}
