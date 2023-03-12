package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.CourseRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired   // it is dependancy injection
    CourseRepository courseRepository;

    @Autowired   // for fk
    StudentRepository studentRepository;

    public void addCourse() {

        Course courseObj = new Course();
        courseObj.setName("python");
        courseRepository.save(courseObj);
    }

    public List<Course> getAllCourses() {

        return courseRepository.getAllCourses();
    }

    public void deleteCourseById(Integer id) {
        Course courseToDelete = courseRepository.findById(id).get();
        courseRepository.delete(courseToDelete);
    }

    //getById
    public Course getCourseById(Integer id) {
        Course course = courseRepository.getCourseById(id);
        return course;
    }

    //geByCourseName :-
    public Course getCourseByCourseName(String name) {
        Course course = courseRepository.getCourseByCourseName(name);
        return course;
    }

    //for fk:-
    public List<Course> getCoursesByStudentName(String studentName) {
        Student student = studentRepository.getStudentByStudentName(studentName);
        Integer studentId = student.getId();
        List<Course> courseList = courseRepository.getCoursesByStudentId(studentId);
        return courseList;
    }

    // getAllActiveCourses :-
    public List<Course> getAllActiveCourses() {

        return courseRepository.getAllActiveCourses();
    }

    // getAllNotActiveCourses :-
    public List<Course> getAllInActiveCourses(){

        return courseRepository.getAllInActiveCourses();
    }

    //deleteByColumnNameCourseName :-
    public void deleteCourseByColumnNameCourseName(String name){
        Course courseToDelete = courseRepository.getCourseByCourseName(name); //just change in this line
        //  School schoolToDelete = schoolRepository.findById(id).get();
        courseRepository.delete(courseToDelete);
    }

    //updateCreatedDateByUserInputForCourse :-
    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        Course course = courseRepository.getCourseById(id);
        course.setCreatedDate(convertedDateFromStringToDateFormat);
        courseRepository.save(course);
    }

    public void getPutIsActiveFalseByCourseId(Integer id) {

        courseRepository.getPutIsActiveFalseByCourseId(id);
    }

    public void getPutIsActiveFalseByCourseName(String name) {

        courseRepository.getPutIsActiveFalseByCourseName(name);
    }

    //deleteByAll--> they mean  MakeIsActiveFalseForAllSchools
    public void getPutIsActiveFalseForAllCourses() {
        courseRepository.getPutIsActiveFalseForAllCourses();
        //    school.setActive(false);
        //  schoolRepository.saveAll(schools);
    }

    public void getUpdateCourseById(Integer id,String name) {
        courseRepository.getUpdateCourseById(id,name);
        //    school.setActive(false);
        //  schoolRepository.saveAll(schools);
    }

    public Course getLatestRowCourse() {

        return courseRepository.getLatestRowCourse();
    }

    //getLatestUpdated
    public Course getLatestUpdatedCourse() {
        Course course = courseRepository.getLatestUpdatedCourse();
        return course;
    }



}
