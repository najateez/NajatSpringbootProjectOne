package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Component
//@RestController
public class MarkController {

    @Autowired
    MarkService markService;

    @GetMapping
    public void addMark(){

        markService.addMark();
    }

    @RequestMapping(value="mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks(){
        List<Mark> theMark = markService.getAllMarks();
        return theMark;
    }

    @GetMapping(value = "mark/deleteById")
    public String deleteMarkById(@RequestParam Integer id){

        markService.deleteMarkById(id);
        return "Record of mark table deleted successfully";
    }

    @RequestMapping(value = "mark/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer markId){
        Mark mark = markService.getMarkById(markId);
        return mark;
    }

    //exp: localhost:8080/mark/getByColumnObtainedMarks?obtainedMarks=82
    @RequestMapping(value = "mark/getByColumnObtainedMarks", method = RequestMethod.GET)
    public Mark getMarkByObtainedMarks(@RequestParam Integer obtainedMarks){
        Mark mark = markService.getMarkByObtainedMarks(obtainedMarks);
        return mark;
    }

    // getAllActiveMarks :-
    @RequestMapping(value = "getAllMarksByIsActive")
    public List<Mark> getAllActiveMarks() {
        List<Mark> activeMarksList = markService.getAllActiveMarks();
        return activeMarksList;
    }

    // getAllNotActiveCourses :-
    @RequestMapping(value = "getAllMarksByIsActiveFalse")
    public List<Mark> getAllInActiveMarks() {
        List<Mark> notInActiveMarksList = markService.getAllInActiveMarks();
        return notInActiveMarksList;
    }

    //deleteMarkByColumnNameGrade :-
 @GetMapping(value = "mark/deleteByColumnNameGrade")
    public String deleteMarkByColumnNameGrade(@RequestParam String grade) {

        markService.deleteMarkByColumnNameGrade(grade);
        return "Record of school table deleted successfully";
    }

    //updateCreatedDateByUserInputForMark :-
    @RequestMapping(value = "mark/updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        markService.setCreatedDateByUserInput(date, id);
    }

    //deleteById--> they mean  MakeIsActiveFalseByMarkId
    @RequestMapping(value = "deleteMarkByIdIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseByMarkId(@RequestParam Integer markId) {
        markService.getPutIsActiveFalseByMarkId(markId);
    }

    //deleteByColumnName--> they mean  MakeIsActiveFalseByColumnName
    @RequestMapping(value = "mark/deleteByObtainedMarksIsActiveFalse", method = RequestMethod.POST)
    public void getPutIsActiveFalseByColumnNameObtainedMarks(@RequestParam Integer obtainedMarks) {
        markService.getPutIsActiveFalseByColumnNameObtainedMarks(obtainedMarks);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllMarks
    //exp: localhost:8080/mark/deleteByAllPutIsActiveFalseByMarkForAll
    @RequestMapping(value = "mark/deleteByAllPutIsActiveFalseByMarkForAll", method = RequestMethod.POST)
    public void getPutIsActiveFalseForAllMarks() {
        markService.getPutIsActiveFalseForAllMarks();
    }

    //updateMark :-
    //exp: localhost:8080/mark/updateMark?obtainedMarks=96&markId=1
    @RequestMapping(value = "mark/updateMark", method = RequestMethod.POST)
    public void getUpdateMarkById(@RequestParam Integer markId, @RequestParam Integer obtainedMarks) {
        markService.getUpdateMarkById(markId,obtainedMarks);
    }

    //getLatestRow
    // exp: localhost:8080/mark/getLatestRowMark
    @RequestMapping(value = "mark/getLatestRowMark")
    public Mark getLatestRowMark() {
        Mark mark = markService.getLatestRowMark();
        return mark;
    }

    //getLatestUpdated
    @RequestMapping(value = "mark/getLatestUpdatedMark", method = RequestMethod.GET)
    public Mark getLatestUpdatedMark() {
        Mark mark = markService.getLatestUpdatedMark();
        return mark;
    }

    //getCreatedAfterDate
    @RequestMapping(value = "mark/getMarkCreatedAfterDate", method = RequestMethod.GET)
    public List<Mark> getCreatedAfterDateMark(@RequestParam String createdDate) throws ParseException {
        List<Mark> createdAfterDate = markService.getCreatedAfterDateMark(createdDate);
        return createdAfterDate;
    }

    //UpdateIsActiveTrueBySchoolId
    @RequestMapping(value = "mark/updateIsActiveToTrueByMarkId", method = RequestMethod.POST)
    public void getUpdateIsActiveTrueByMarkId(@RequestParam Integer markId) {
        markService.getUpdateIsActiveTrueByMarkId(markId);
    }

    //updateUpdatedDateByUserInputForMark :-
    //exp: localhost:8080/mark/updateUpdatedDateByUserInput?date=1234-12-11&id=1
    @RequestMapping(value = "mark/updateUpdatedDateByUserInput")
    public void setUpdateUpdatedDateByUserInput(@RequestParam String date, @RequestParam Integer id) throws ParseException {

        markService.setUpdateUpdatedDateByUserInput(date, id);
    }

    //getByObtainedMarksMoreThan
    //exp: localhost:8080/mark/getByObtainedMarksMoreThan?obtainedMarks=30
    @RequestMapping(value = "mark/getByObtainedMarksMoreThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksMoreThan(@RequestParam Integer obtainedMarks) {

        return markService.getByObtainedMarksMoreThan(obtainedMarks);
    }

    //getByObtainedMarksLessThan
    //exp: localhost:8080/mark/getByObtainedMarksLessThan?obtainedMarks=30
    @RequestMapping(value = "mark/getByObtainedMarksLessThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksLessThan(@RequestParam Integer obtainedMarks) {

        return markService.getByObtainedMarksLessThan(obtainedMarks);
    }

    //addNewMarkDependOfMarkInput
    //exp: localhost:8080/Mark/addNewMarkDependOfMarkInput?isActive=false&grade=very good&obtainedMarks=94
    //used SchoolService, schoolController.
    //same as previous code of addSchool() but with parameter.
    @RequestMapping(value = "Mark/addNewMarkDependOfMarkInput", method = RequestMethod.POST)
    public void addNewMarkDependOfMarkInput(@RequestParam String grade, @RequestParam Integer obtainedMarks, @RequestParam Boolean isActive) {

        markService.addNewMarkDependOfMarkInput(grade,obtainedMarks,isActive);
    }

    //getMarkByCreatedDate :-
    //exp: localhost:8080/mark/getMarkByCreatedDate?createdDate=1234-05-06 00:00:00.0000000
    //note: always date we will convert it to string, with parseException
    @RequestMapping(value = "mark/getMarkByCreatedDate", method = RequestMethod.GET)
    public List<Mark> getMarkByCreatedDate(@RequestParam String createdDate) throws ParseException {
        List<Mark> mark = markService.getMarkByCreatedDate(createdDate);
        return mark;
    }

    //deleteMarkByCreatedDate -> put isActive false by createdDate :-
    //exp: localhost:8080/mark/UpdateIsActiveFalseByCreatedDate?createdDate=1111-06-08 00:00:00.0000000
    @RequestMapping(value = "mark/UpdateIsActiveFalseByCreatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByCreatedDate(@RequestParam String createdDate) throws ParseException{
        markService.getUpdateIsActiveFalseByCreatedDate(createdDate);
    }

    //getMarkByUpdatedDate
    //exp: localhost:8080/mark/getSchoolByUpdatedDate?updatedDate=2023-03-19
    //to work this code should time be in db all zero's.
    @RequestMapping(value = "mark/getMarkByUpdatedDate", method = RequestMethod.GET)
    public List<Mark> getMarkByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        List<Mark> mark = markService.getMarkByUpdatedDate(updatedDate);
        return mark;
    }

    //deleteMarkByUpdatedDate -> put isActive false by UpdatedDate :-
    //exp: localhost:8080/mark/UpdateIsActiveFalseByUpdatedDate?updatedDate=2023-03-13 00:00:00.0000000
    // to work this one should time be in db all zero's.
    @RequestMapping(value = "mark/UpdateIsActiveFalseByUpdatedDate", method = RequestMethod.POST)
    public void getUpdateIsActiveFalseByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        markService.getUpdateIsActiveFalseByUpdatedDate(updatedDate);
    }
    //*********

    //deleteAllSchoolsCreatedAfterDate -> put isActive false for AllSchoolsCreatedAfterDate
    //exp: localhost:8080/school/deleteAllMarksCreatedAfterDate?createdDate=1234-05-06 00:00:00.0000000
    // to work this one should time be in db all zero's.
    @RequestMapping(value = "mark/deleteAllMarksCreatedAfterDate", method = RequestMethod.POST)
    public void getDeleteAllMarksCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        markService.getDeleteAllMarksCreatedAfterDate(createdDate);

    }




}
