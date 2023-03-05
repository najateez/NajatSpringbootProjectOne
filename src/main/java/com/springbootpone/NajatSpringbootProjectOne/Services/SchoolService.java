package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.hibernate.hql.internal.ast.tree.DeleteStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired //to link schoolService with schoolRepository.
    SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void addSchool() {

        School schoolObj = new School();
        schoolObj.setName("madrasa");
        schoolRepository.save(schoolObj);
    }

    //this getAllSchools list to show data from table to screen.
    public List<School> getAllSchools() {

        return schoolRepository.getAllSchools();
    }

    public void deleteSchoolById(Integer id) {
        School schoolToDelete = schoolRepository.findById(id).get();
        schoolRepository.delete(schoolToDelete);
    }

    // getById :-
    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    //getBySchoolName :-
    public School getSchoolBySchoolName(String name) {
        School school = schoolRepository.getSchoolBySchoolName(name);
        return school;
    }

    // getAllActiveSchools :-
    public List<School> getAllActiveSchools() {

        return schoolRepository.getAllActiveSchools();
    }

    // getAllNotActiveSchools :-
    public List<School> getAllInActiveSchools() {

        return schoolRepository.getAllInActiveSchools();
    }


    //deleteByColumnNameSchoolName ... its same as deleteById but little changes in code
    public void deleteSchoolByColumnNameSchoolName(String name) {
        School schoolToDelete = schoolRepository.getSchoolBySchoolName(name); //just change in this line
        //  School schoolToDelete = schoolRepository.findById(id).get();
        schoolRepository.delete(schoolToDelete);
    }

    //updateCreatedDateByUserInputForSchool :-
  public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }

 /*  public void getPutisActiveFalseByIdSchools(boolean isActive, Integer id) throws ParseException {


        School school = schoolRepository.getSchoolById(id);

        if (school.getActive()== false) {
            throw new RuntimeException("School is Already inActive!!");
        }

        school.setActive(false);

        schoolRepository.save(school);
    } */



}
