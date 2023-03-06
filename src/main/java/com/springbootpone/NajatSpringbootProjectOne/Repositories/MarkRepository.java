package com.springbootpone.NajatSpringbootProjectOne.Repositories;


import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

    //getAllNotActiveMarks :-
    @Query(value = "SELECT mrk from Mark mrk where mrk.isActive = false")
    List<Mark> getAllInActiveMarks();


    //getByColumnNameGrade .. here cove below just i added to use it for deleteByColumnNameGrade
    @Query(value = "SELECT s from Mark s where s.grade = :grade")  // :grade -> for user input
    Mark getMarkByColumnNameGrade(@Param("grade") String grade);

    //deleteById--> they mean  MakeIsActiveFalseByCourseId
    @Modifying
    @Transactional
    @Query(value = "UPDATE Mark s SET s.isActive = false WHERE s.id =:markId")
    void getPutIsActiveFalseByMarkId(@Param("markId") Integer id);

    //deleteByColumnName--> they mean  MakeIsActiveFalseByMarkColumnName
    @Modifying
    @Transactional
    @Query(value = "UPDATE Mark m SET m.isActive = false WHERE m.obtainedMarks =:obtainedMarks")
    void getPutIsActiveFalseByColumnNameObtainedMarks(@Param("obtainedMarks") Integer obtainedMarks);

}
