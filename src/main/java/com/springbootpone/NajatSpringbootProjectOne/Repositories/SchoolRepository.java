package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
//public interface SchoolRepository extends CrudRepository<School,Integer> {
public interface SchoolRepository extends JpaRepository<School, Integer> {

    //to get output of table in screen : schoolRepositry->SchoolService->FirstController
    @Query("SELECT s from School s")
    //sql query

    List<School> getAllSchools();

    //getById :-
    @Query(value = "SELECT s from School s where s.id = :schoolId")
    // :schoolId -> for user input
    School getSchoolById(@Param("schoolId") Integer id);

    //getByColumnName :-  (column name depend on what you write in model package).
    @Query(value = "SELECT s from School s where s.name = :schoolName")
    // :schoolName -> for user input
    School getSchoolBySchoolName(@Param("schoolName") String name);

    //getAllActiveSchools :-
    @Query(value = "SELECT s from School s where s.isActive = true")
    List<School> getAllActiveSchools();

    //getAllNotActiveSchools :-
    @Query(value = "SELECT s from School s where s.isActive = false")
    List<School> getAllInActiveSchools();


    //deleteById--> they mean  MakeIsActiveFalseBySchoolId
    //@Modifying and @Transactional used when we want to update something
    @Modifying
    @Transactional
    @Query(value = "UPDATE School s SET s.isActive = false WHERE s.id =:schoolId")
    void getPutIsActiveFalseBySchoolId(@Param("schoolId") Integer id);


}
