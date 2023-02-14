package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
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

    //getByColumnName :-  (column name depend on what you write in model package).
    @Query(value = "SELECT s from Course s where s.name = :courseName")  // :schoolName -> for user input
    Course getCourseByCourseName(@Param("courseName") String name);

    //  the way of adding fk (foreign key)..
    @Query(value = "SELECT c from Course c where c.student.id = :id")
    List<Course> getCoursesByStudentId(@Param("id")Integer id);


}
