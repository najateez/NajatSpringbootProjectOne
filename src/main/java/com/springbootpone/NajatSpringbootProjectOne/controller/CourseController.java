package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

}
