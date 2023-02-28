package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


// this for create/insert, update, delete,read.
@Repository                                             //class name , primary key
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("SELECT s from Student s")  //sql query
    List<Student> getAllStudents();

    //getById :-
    @Query(value = "SELECT s from Student s where s.id = :studentId")  // :studentId -> for user input
    Student getStudentById(@Param("studentId") Integer id);

    //getByColumnName :-  (column name depend on what you write in model package).
    @Query(value = "SELECT s from Student s where s.name = :studentName")  // :studentName -> for user input
    Student getStudentByStudentName(@Param("studentName") String name);

   //  the way of adding fk (foreign key).. school id in student table.
   @Query(value = "SELECT st from Student st where st.school.id = :id")
    List<Student> getStudentsBySchoolId(@Param("id")Integer id);

    //getAllActiveStudents :-
    @Query(value = "SELECT s from Student s where s.isActive = true")
    List<Student> getAllActiveStudents();

    //getAllNotActiveStudents :-
    @Query(value = "SELECT s from Student s where s.isActive = false")
    List<Student> getAllInActiveStudents();






}
