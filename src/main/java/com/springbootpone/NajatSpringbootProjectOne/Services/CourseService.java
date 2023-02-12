package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.CourseRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired   // it is dependancy injection
    CourseRepository courseRepository;

    public void addCourse(){

        Course courseObj=new Course();
        courseObj.setName("php");
        courseRepository.save(courseObj);
    }

    public List<Course> getAllCourses() {

        return courseRepository.getAllCourses();
    }

    public void deleteCourseById(Integer id){
        Course courseToDelete = courseRepository.findById(id).get();
        courseRepository.delete(courseToDelete);
    }

}
