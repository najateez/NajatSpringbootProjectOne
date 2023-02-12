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

    //Generate setters & getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(Integer obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
