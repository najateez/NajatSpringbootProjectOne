package com.springbootpone.NajatSpringbootProjectOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class MarkDTO {

    //for Mark with Course Report.

    private String courseName;
    private Integer obtainedMarks;
    private String grade;
    private Double averageMark;
    private Integer countGrade;

    // generating constructors with parameter

    //for question 2
    public MarkDTO(String courseName, Integer obtainedMarks, String grade) {
        this.courseName = courseName;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
    }

    //for question 3
    public MarkDTO(String courseName, Double averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }

    //for question 7
    public MarkDTO(String courseName, String grade, Integer countGrade) {
        this.courseName = courseName;
        this.grade = grade;
        this.countGrade = countGrade;
    }
}
