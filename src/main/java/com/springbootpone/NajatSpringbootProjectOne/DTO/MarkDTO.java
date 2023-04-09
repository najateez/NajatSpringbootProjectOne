package com.springbootpone.NajatSpringbootProjectOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class MarkDTO {

    //for Mark with Course Report. for Q2,Q3

    private String courseName;
    private Integer obtainedMarks;
    private String grade;
    private Double averageMark;

    // generating constructors with parameter

    public MarkDTO(String courseName, Integer obtainedMarks, String grade) {
        this.courseName = courseName;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
    }

    public MarkDTO(String courseName, Double averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }
}
