package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SchoolService {

    @Autowired //to link schoolService with schoolRepository.
    SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void addSchool() {

        School schoolObj = new School();
        schoolObj.setName("madrasa");
        schoolRepository.save(schoolObj); //for insert
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

    //deleteById--> they mean  MakeIsActiveFalseBySchoolId
    public void getPutIsActiveFalseBySchoolId(Integer id) {

        schoolRepository.getPutIsActiveFalseBySchoolId(id); //here isActive will be false because of update query
//        school.setActive(false);
//        schoolRepository.save(school); //for update also
    }

    //deleteByColumnName--> they mean  MakeIsActiveFalseBySchoolColumnName
    public void getPutIsActiveFalseBySchoolColumnName(String name) {

        schoolRepository.getPutIsActiveFalseBySchoolColumnName(name);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllSchools
    public void getPutIsActiveFalseForAllSchools() {
        schoolRepository.getPutIsActiveFalseForAllSchools();
      //    school.setActive(false);
      //  schoolRepository.saveAll(schools);
    }

    public void getUpdateSchoolById(Integer id,String name) {
        schoolRepository.getUpdateSchoolById(id,name);
        //    school.setActive(false);
        //  schoolRepository.saveAll(schools);
    }

    public School getLatestRowSchool() {

        return schoolRepository.getLatestRowSchool();
    }

    //getLatestUpdated
    public School getLatestUpdatedSchool() {
        School school = schoolRepository.getLatestUpdatedSchool();
        return school;
    }

    //getCreatedAfterDate
    public List<School> getCreatedAfterDateSchool(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<School> schools = schoolRepository.getCreatedAfterDateSchool(convertedDateFromStringToDateFormat);
        return schools;
    }

    //getSchoolByNumberOfStudents
    public List<School> getSchoolByNumberOfStudent(Integer numberOfStudent ) {

        List<Integer> typesOfSchoolIdsInStudent = studentRepository.getDistinctSchoolIdsFromStudent();

        List<Integer> schoolIdsThatUserWants = new ArrayList<>();
        for (Integer idOfSchool : typesOfSchoolIdsInStudent) {
            Integer count = studentRepository.getCountOfStudentsBySchoolId(idOfSchool);

            if (numberOfStudent == count) {
                schoolIdsThatUserWants.add(idOfSchool);
            }
        }

        List<School> schoolThatUserWasLookingFor = schoolRepository.findAllById(schoolIdsThatUserWants);
        return schoolThatUserWasLookingFor;
    }

    //UpdateIsActiveTrueBySchoolId
    public void getUpdateIsActiveTrueBySchoolId(Integer id) {

        schoolRepository.getUpdateIsActiveTrueBySchoolId(id);
    }

    //updateUpdatedDateById
    public void setUpdateUpdatedDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id);
        school.setUpdatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }


}
