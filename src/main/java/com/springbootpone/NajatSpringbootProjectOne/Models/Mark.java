package com.springbootpone.NajatSpringbootProjectOne.Models;

import lombok.Data;

import javax.persistence.*;


@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer obtainedMarks;
    String grade;

    @ManyToOne
    @JoinColumn(name= "course_id" , referencedColumnName = "id")
    Course course;
}
