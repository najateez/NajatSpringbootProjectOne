package com.springbootpone.NajatSpringbootProjectOne.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="school_name")
    String name;

    @OneToMany   //One school, many students
    @JoinColumn(referencedColumnName = "id")  // for fk
    List<Student> theStudent; //students he wrote

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

    public List<Student> getTheStudent() {
        return theStudent;
    }

    public void setTheStudent(List<Student> theStudent) {
        this.theStudent = theStudent;
    }
}
