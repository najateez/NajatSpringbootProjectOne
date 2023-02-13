package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SchoolRepository extends CrudRepository<School,Integer> {

    //to get output of table in screen : schoolRepositry->SchoolService->FirstController
    @Query("SELECT s from School s")  //sql query

    List<School> getAllSchools();

    //getById :-
    @Query(value = "SELECT s from School s where s.id = :schoolId")  // :schoolId -> for user input
    School getSchoolById(@Param("schoolId") Integer id);

    //getByColumnName :-  (column name depend on what you write in model package).
    @Query(value = "SELECT s from School s where s.name = :schoolName")  // :schoolName -> for user input
    School getSchoolBySchoolName(@Param("schoolName") String name);
}
