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

    //Generate setters & getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
