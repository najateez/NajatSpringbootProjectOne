package com.springbootpone.NajatSpringbootProjectOne.Models;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@Entity  //above each class should be Entity notation
public class School extends BaseEntity {

    @Id    //because primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //for auto increment.
    Integer id;
    @Column(name="school_name")
    String name;


    /* Note:
    - just examples:
      - If objectchaining : @OneToOne . will be     Student student;
      - if objectchaing list : @ManyToOne. will be List<Student> theStudent;
      - to see objectchaining between tables from database: right click on school table... click view dependencies.
     */

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
}
