package com.springbootpone.NajatSpringbootProjectOne.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
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

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer>{

    @Query("SELECT s from Course s")  //sql query

    List<Course> getAllCourses();

    //getById :-
    @Query(value = "SELECT s from Course s where s.id = :courseId")  // :courseId -> for user input
    Course getCourseById(@Param("courseId") Integer id);

    //getByColumnName :-  (column name depend on what you write in model package).
    @Query(value = "SELECT s from Course s where s.name = :courseName")  // :schoolName -> for user input
    Course getCourseByCourseName(@Param("courseName") String name);

    //  the way of adding fk (foreign key)..
    @Query(value = "SELECT c from Course c where c.student.id = :id")
    List<Course> getCoursesByStudentId(@Param("id")Integer id);

    //getAllActiveCourses :-
    @Query(value = "SELECT c from Course c where c.isActive = true")
     List<Course> getAllActiveCourses();

    //getAllNotActiveCourses :-
    @Query(value = "SELECT crs from Course crs where crs.isActive = false")
    List<Course> getAllInActiveCourses();

   //deleteById--> they mean  MakeIsActiveFalseByCourseId
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course s SET s.isActive = false WHERE s.id =:courseId")
    void getPutIsActiveFalseByCourseId(@Param("courseId") Integer id);

    //deleteByColumnName--> they mean  MakeIsActiveFalseByCourseColumnName
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course c SET c.isActive = false WHERE c.name =:courseName")
    void getPutIsActiveFalseByCourseName(@Param("courseName") String name);

    //deleteByAll--> they mean  MakeIsActiveFalseForAllCourses
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course s SET s.isActive = false")
    void getPutIsActiveFalseForAllCourses();

    //updateSchool :-
// https://www.baeldung.com/spring-data-partial-update -> i got query from here
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course s SET s.name=:courseName WHERE s.id =:courseId")
    void getUpdateCourseById(@Param("courseId") Integer id,@Param("courseName") String name);


    //getLatestRow :-
    @Query("SELECT s FROM Course s WHERE s.id =(SELECT MAX(s.id) FROM Course s)")
    Course getLatestRowCourse();

    //getLatestUpdated
    @Query(value ="SELECT s from Course s where s.updatedDate = (SELECT max(s.updatedDate) from Course s)")
    Course getLatestUpdatedCourse();

    //getCreatedAfterDate
    @Query("SELECT s from Course s where s.createdDate > :createdDate")
    List<Course> getCreatedAfterDateCourse(Date createdDate);

    //UpdateIsActiveTrueBySchoolId
    //@Modifying and @Transactional used when we want to update something
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course s SET s.isActive = true WHERE s.id =:courseId")
    void getUpdateIsActiveTrueByCourseId(@Param("courseId") Integer id);

    //getCourseByCreatedDate
    @Query(value = "SELECT s from Course s where s.createdDate =:createdDate")
    List<Course> getCourseByCreatedDate(@Param("createdDate") Date createdDate);


    //deleteCourseByCreatedDate -> put isActive false by createdDate :-
    //Note: if you use @Modifying notation, use all void in(Repository,Service,Controller). ALWAYS.
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course s SET s.isActive = false WHERE s.createdDate =:createdDate")
    void getUpdateIsActiveFalseByCreatedDate(@Param("createdDate") Date createdDate);

    //getCourseByUpdatedDate
    @Query(value = "SELECT s from Course s where s.updatedDate =:updatedDate")
    List<Course> getCourseByUpdatedDate(@Param("updatedDate") Date updatedDate);

    //deleteCoursesByUpdatedDate -> put isActive false by UpdatedDate :-
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course s SET s.isActive = false WHERE s.updatedDate =:updatedDate")
    void getUpdateIsActiveFalseByUpdatedDate(@Param("updatedDate") Date updatedDate);
//********

    //deleteAllCoursesCreatedAfterDate -> put isActive false for AllCoursesCreatedAfterDate
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course s SET s.isActive = false WHERE s.createdDate >:createdDate")
    void getDeleteAllCoursesCreatedAfterDate(@Param("createdDate") Date createdDate);


}
