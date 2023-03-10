package com.springbootpone.NajatSpringbootProjectOne.Models;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// here no need to create notation for setter and getter because already we generate setter and getter. also no need for @Data.
//@Data  -> it is for constructor this notation
//@Getter
//@Setter
@Entity
//@Table(name= "dbo.student")   //no need for this because already when we run program will create table. with it will create 2 student tables in database.
public class Student extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment id.(idintity).  .auto-> any number. .sequence -> if you give number 7 after will give 8
    Integer id;

    @Column(name="student_name")
    String name;

    String rollNumber;
    @ManyToOne  //many students , one school
    @JoinColumn(name= "school_id" ,referencedColumnName = "id")
    School school;

    //   List<Course> theCourse; //courses he wrote

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

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
