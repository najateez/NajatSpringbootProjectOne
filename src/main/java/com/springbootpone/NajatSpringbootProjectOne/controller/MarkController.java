package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


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
    public Mark getCourseByCourseName(@RequestParam Integer obtainedMarks){
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



}
