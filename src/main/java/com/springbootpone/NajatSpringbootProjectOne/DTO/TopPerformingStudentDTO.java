package com.springbootpone.NajatSpringbootProjectOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class TopPerformingStudentDTO {

    //for Question 4

    private String schoolName;
    private String studentName;
    private Integer obtainedMarks;

    public TopPerformingStudentDTO(String schoolName, String studentName, Integer obtainedMarks) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.obtainedMarks = obtainedMarks;
    }
}
