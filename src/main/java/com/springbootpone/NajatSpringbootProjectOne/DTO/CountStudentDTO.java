package com.springbootpone.NajatSpringbootProjectOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class CountStudentDTO {

    //for Question 9
     String courseName;
     Integer countNoOfStudents;

    public CountStudentDTO(String courseName, Integer countNoOfStudents) {
        this.courseName = courseName;
        this.countNoOfStudents = countNoOfStudents;
    }
}
