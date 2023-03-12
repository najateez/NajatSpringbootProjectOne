package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.CourseRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MarkService {

    @Autowired   // it is dependancy injection
    MarkRepository markRepository;

    @Autowired   // for fk
    CourseRepository courseRepository;

    public void addMark(){

        Mark markObj=new Mark();
        markObj.setObtainedMarks(93);
        markObj.setGrade("excellent");
        markRepository.save(markObj);
    }

    public List<Mark> getAllMarks() {

        return markRepository.getAllMarks();
    }

    public void deleteMarkById(Integer id){
        Mark markToDelete = markRepository.findById(id).get();
        markRepository.delete(markToDelete);
    }

    //getById
    public Mark getMarkById(Integer id){
        Mark mark = markRepository.getMarkById(id);
        return mark;
    }

    //getBySchoolName :-
    public Mark getMarkByObtainedMarks(Integer obtainedMarks) {
        Mark mark = markRepository.getMarkByObtainedMarks(obtainedMarks);
        return mark;
    }

    //for fk:-
    public List<Mark> getMarkByCourseName(String courseName){
        Course course = courseRepository.getCourseByCourseName(courseName);
        Integer courseId = course.getId();
        List<Mark> markList = markRepository.getMarksByCourseId(courseId);
        return markList;
    }

    // getAllActiveMarks :-
    public List<Mark> getAllActiveMarks(){

        return markRepository.getAllActiveMarks();
    }

    // getAllNotActiveMarks :-
    public List<Mark> getAllInActiveMarks(){

        return markRepository.getAllInActiveMarks();
    }

    //deleteByColumnNameGrade
    public void deleteMarkByColumnNameGrade(String grade){
        Mark markToDelete = markRepository.getMarkByColumnNameGrade(grade); //just change in this line
        //  School schoolToDelete = schoolRepository.findById(id).get();
        markRepository.delete(markToDelete);
    }

    //updateCreatedDateByUserInputForMark :-
    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        Mark mark = markRepository.getMarkById(id);
        mark.setCreatedDate(convertedDateFromStringToDateFormat);
        markRepository.save(mark);
    }

    public void getPutIsActiveFalseByMarkId(Integer id) {

        markRepository.getPutIsActiveFalseByMarkId(id);
    }

    public void getPutIsActiveFalseByColumnNameObtainedMarks(Integer obtainedMarks) {

        markRepository.getPutIsActiveFalseByColumnNameObtainedMarks(obtainedMarks);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllSchools
    public void getPutIsActiveFalseForAllMarks() {
        markRepository.getPutIsActiveFalseForAllMarks();
        //    school.setActive(false);
        //  schoolRepository.saveAll(schools);
    }

    public void getUpdateMarkById(Integer id,Integer obtainedMarks) {
        markRepository.getUpdateMarkById(id,obtainedMarks);
        //    school.setActive(false);
        //  schoolRepository.saveAll(schools);
    }

    public Mark getLatestRowMark() {

        return markRepository.getLatestRowMark();
    }

    //getLatestUpdated
    public Mark getLatestUpdatedMark() {
        Mark mark = markRepository.getLatestUpdatedMark();
        return mark;
    }




}
