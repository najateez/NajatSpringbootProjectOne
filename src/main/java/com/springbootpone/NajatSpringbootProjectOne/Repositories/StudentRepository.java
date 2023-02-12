package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// this for create/insert, update, delete,read.
@Repository                                             //class name , primary key
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("SELECT s from Student s")  //sql query
    List<Student> getAllStudents();

}
