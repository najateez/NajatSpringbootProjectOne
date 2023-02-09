package com.springbootpone.NajatSpringbootProjectOne.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="course_name")
    String name;
    @ManyToOne  //many students, one course.
    @JoinColumn(name= "student_id" , referencedColumnName = "id")
    Student student;


}
