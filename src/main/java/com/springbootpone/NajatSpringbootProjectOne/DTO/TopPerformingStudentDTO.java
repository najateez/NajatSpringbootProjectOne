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

    /* will calculate total sum of obtainedMarks of that course of that student of that school, then which is the
       highest will be the top to ...
     */
    private Integer obtainedMarks;

    public TopPerformingStudentDTO(String schoolName, String studentName, Integer obtainedMarks) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.obtainedMarks = obtainedMarks;
    }
}
