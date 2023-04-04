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


    public StudentDTO(String schoolName, String studentName, String rollNumber) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }
}
