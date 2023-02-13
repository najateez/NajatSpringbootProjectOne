package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired //to link schoolService with schoolRepository.
    SchoolRepository schoolRepository;

    public void addSchool(){

        School schoolObj=new School();
        schoolObj.setName("disney school");
        schoolRepository.save(schoolObj);
    }

    //this getAllSchools list to show data from table to screen.
    public List<School> getAllSchools() {

        return schoolRepository.getAllSchools();
    }

    public void deleteSchoolById(Integer id){
        School schoolToDelete = schoolRepository.findById(id).get();
        schoolRepository.delete(schoolToDelete);
    }
     // getById :-
    public School getSchoolById(Integer id){
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    //getBySchoolName :-
    public School getSchoolBySchoolName(String name) {
        School school = schoolRepository.getSchoolBySchoolName(name);
        return school;
    }

}
