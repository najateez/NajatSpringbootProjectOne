package com.springbootpone.NajatSpringbootProjectOne.Repositories;


import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
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

}
