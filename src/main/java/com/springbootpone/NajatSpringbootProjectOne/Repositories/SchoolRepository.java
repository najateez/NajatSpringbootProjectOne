package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SchoolRepository extends CrudRepository<School,Integer> {
    @Query("SELECT s from School s")  //sql query

    List<School> getAllSchools();

}
