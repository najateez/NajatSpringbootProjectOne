package com.springbootpone.NajatSpringbootProjectOne.Models;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// here no need to create notation for setter and getter because already we generate setter and getter.
//@Data  -> it is for constructor this notation
//@Getter
//@Setter
@Entity
//@Table(name= "dbo.student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment id.(idintity).  .auto-> any number. .sequence -> if you give number 7 after will give 8
    Integer id;

    @Column(name="student_name")
    String name;

    String rollNumber;
    List<Course> theCourse; //courses he wrote

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
}
