package com.springbootpone.NajatSpringbootProjectOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class StudentPerformanceDTO {

    //for Question 5
    private String studentName;
    private String rollNumber;
    private Double averageMarkOfObtainedMarks;

    public StudentPerformanceDTO(String studentName, String rollNumber, Double averageMarkOfObtainedMarks) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.averageMarkOfObtainedMarks = averageMarkOfObtainedMarks;
    }
}
