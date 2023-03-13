package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
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

    //deleteById--> they mean  MakeIsActiveFalseByStudentId
    @Modifying
    @Transactional
    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.id =:studentId")
    void getPutIsActiveFalseByStudentId(@Param("studentId") Integer id);

    //deleteByColumnName--> they mean  MakeIsActiveFalseByStudentColumnName
    @Modifying
    @Transactional
    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.name =:studentName")
    void getPutIsActiveFalseByStudentName(@Param("studentName") String name);



    //deleteByAll--> they mean  MakeIsActiveFalseForAllSchools
    @Modifying
    @Transactional
    @Query(value = "UPDATE Student s SET s.isActive = false")
    void getPutIsActiveFalseForAllStudents();

    //updateSchool :-
// https://www.baeldung.com/spring-data-partial-update -> i got query from here
    @Modifying
    @Transactional
    @Query(value = "UPDATE Student s SET s.name=:studentName WHERE s.id =:studentId")
    void getUpdateStudentById(@Param("studentId") Integer id,@Param("studentName") String name);


    //getLatestRow :-
    @Query("SELECT s FROM Student s WHERE s.id =(SELECT MAX(s.id) FROM Student s)")
    Student getLatestRowStudent();

    //getLatestUpdated
    @Query(value ="SELECT s from Student s where s.updatedDate = (SELECT max(s.updatedDate) from Student s)")
    Student getLatestUpdatedStudent();

    //getCreatedAfterDate
    @Query("SELECT s from Student s where s.createdDate > :createdDate")
    List<Student> getCreatedAfterDateStudent(Date createdDate);

    //getSchoolByNumberOfStudents
    @Query(value = "SELECT DISTINCT school_id FROM student", nativeQuery = true)
    List<Integer> getDistinctSchoolIdsFromStudent();
    @Query(value = "SELECT COUNT(id) From student where school_id =:schoolId", nativeQuery = true)
    Integer getCountOfStudentsBySchoolId(Integer schoolId);








}
