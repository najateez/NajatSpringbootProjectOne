package com.springbootpone.NajatSpringbootProjectOne.DTO;

import lombok.*;

@Setter
@Getter
@Data
//@AllArgsConstructor
public class StudentDTO {

    //for Student with School Report. for Q1

    //i will create for all these properties (.jrxml) file. use Jaspersoft
    private String schoolName;
    private String studentName;
    private String rollNumber;
    private Integer totalNoOfStudents;

    //for question 1
    public StudentDTO(String schoolName, String studentName, String rollNumber) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }

    //for question 6
    public StudentDTO(String schoolName, Integer totalNoOfStudents) {
        this.schoolName = schoolName;
        this.totalNoOfStudents = totalNoOfStudents;
    }



}
