package com.springbootpone.NajatSpringbootProjectOne.Repositories;


import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark,Integer> {

    // s is alias
    @Query("SELECT s from Mark s")  //sql query

    List<Mark> getAllMarks();

    //getById :-
    @Query(value = "SELECT s from Mark s where s.id = :markId")  // :schoodId -> for user input
    Mark getMarkById(@Param("markId") Integer id);

    //getByColumnName :-  (column name depend on what you write in model package).
    @Query(value = "SELECT s from Mark s where s.obtainedMarks = :obtainedMarks")  // :schoolName -> for user input
    Mark getMarkByObtainedMarks(@Param("obtainedMarks") Integer obtainedMarks);

    //  the way of adding fk (foreign key)..
    @Query(value = "SELECT m from Mark m where m.course.id = :id")
    List<Mark> getMarksByCourseId(@Param("id")Integer id);

    //getAllActiveMarks :-
    @Query(value = "SELECT mk from Mark mk where mk.isActive = true")
    List<Mark> getAllActiveMarks();

}
