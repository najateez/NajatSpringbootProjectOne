package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// this for create/insert, update, delete,read.
@Repository                                             //class name , primary key
public interface StudentRepository extends CrudRepository<Student,Integer> {



}
