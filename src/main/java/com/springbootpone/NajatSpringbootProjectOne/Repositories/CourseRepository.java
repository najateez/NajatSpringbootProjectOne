package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer>{

    @Query("SELECT s from Course s")  //sql query

    List<Course> getAllCourses();

    //getById :-
    @Query(value = "SELECT s from Course s where s.id = :courseId")  // :courseId -> for user input
    Course getCourseById(@Param("courseId") Integer id);


}
